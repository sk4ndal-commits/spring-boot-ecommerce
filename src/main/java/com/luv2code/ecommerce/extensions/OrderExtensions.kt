package com.luv2code.ecommerce.extensions

import com.luv2code.ecommerce.dto.Purchase
import com.luv2code.ecommerce.entity.Order
import java.util.*

fun Order.placeFromPurchase(purchase: Purchase): String
{
    val orderTrackingNumber = UUID.randomUUID().toString()
    this.orderTrackingNumber = orderTrackingNumber
    this.billingAddress = purchase.billingAddress
    this.shippingAddress = purchase.shippingAddress

    return orderTrackingNumber
}

fun Any?.throwIfNull(message: String?)
{
    if (this == null)
    {
        val exceptionMessage = message ?: ""
        throw IllegalArgumentException(exceptionMessage)
    }
}
