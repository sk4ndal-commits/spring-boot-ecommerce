package com.luv2code.ecommerce.service

import com.luv2code.ecommerce.dao.ICustomerRepository
import com.luv2code.ecommerce.dto.PaymentInfo
import com.luv2code.ecommerce.dto.Purchase
import com.luv2code.ecommerce.dto.PurchaseResponse
import com.luv2code.ecommerce.entity.Customer
import com.luv2code.ecommerce.extensions.placeFromPurchase
import com.stripe.Stripe
import com.stripe.exception.StripeException
import com.stripe.model.PaymentIntent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class CheckoutService(
    private val customerRepository: ICustomerRepository,
    @param:Value($$"${stripe.key.secret}") private val secretKey: String,
) : ICheckoutService
{

    init
    {
        Stripe.apiKey = secretKey
    }

    @Override
    @Transactional
    override fun placeOrder(purchase: Purchase?): PurchaseResponse
    {
        requireNotNull(purchase) { "purchase must not be null" }
        val order = purchase.order ?: throw IllegalArgumentException("order must not be null")

        val orderTrackingNumber = order.placeFromPurchase(purchase)

        val orderItems = purchase.orderItems ?: throw IllegalArgumentException("orderItems must not be null")
        orderItems.forEach(order::add)

        val customer = getCustomer(purchase)
        customer.add(order)
        customerRepository.save(customer)

        return PurchaseResponse(orderTrackingNumber)
    }

    @Throws(StripeException::class)
    override fun createPaymentIntent(paymentInfo: PaymentInfo?): PaymentIntent
    {
        val paymentMethodTypes = listOf("card")

        val params = mapOf(
            "amount" to (paymentInfo?.amount ?: 0),
            "currency" to (paymentInfo?.currency ?: ""),
            "payment_method_types" to paymentMethodTypes,
            "receipt_email" to (paymentInfo?.receiptEmail ?: ""),
            "description" to "Luv2Shop Purchase"
        )

        return PaymentIntent.create(params)
    }

    private fun getCustomer(purchase: Purchase): Customer
    {
        var customer = purchase.customer ?: throw IllegalArgumentException("customer must not be null")
        val email = customer.email ?: throw IllegalArgumentException("email must not be null")
        val customerFromRepository = customerRepository.findByEmail(email)

        if (customerFromRepository != null)
        {
            customer = customerFromRepository
        }

        return customer
    }
}
