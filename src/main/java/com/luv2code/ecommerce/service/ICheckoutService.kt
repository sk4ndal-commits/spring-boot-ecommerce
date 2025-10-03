package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dto.PaymentInfo;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

interface ICheckoutService
{
    fun placeOrder(purchase: Purchase?): PurchaseResponse?

    @Throws(StripeException::class)
    fun createPaymentIntent(paymentInfo: PaymentInfo?): PaymentIntent?
}
