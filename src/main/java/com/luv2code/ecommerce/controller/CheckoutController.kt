package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.PaymentInfo
import com.luv2code.ecommerce.dto.Purchase
import com.luv2code.ecommerce.dto.PurchaseResponse
import com.luv2code.ecommerce.service.ICheckoutService
import com.stripe.exception.StripeException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/checkout")
class CheckoutController(
    private val checkoutService: ICheckoutService,
)
{

    @PostMapping("/purchase")
    fun placeOrder(@RequestBody purchase: Purchase): PurchaseResponse
    {
        return checkoutService.placeOrder(purchase)
    }

    @Throws(StripeException::class)
    @PostMapping("/payment-intent")
    fun createPaymentIntent(@RequestBody paymentInfo: PaymentInfo?): ResponseEntity<String>
    {
        val paymentIntent = checkoutService.createPaymentIntent(paymentInfo)
        val paymentString = paymentIntent.toJson();
        return ResponseEntity<String>(paymentString, HttpStatus.OK);
    }

}
