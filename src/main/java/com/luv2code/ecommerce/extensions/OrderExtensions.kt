package com.luv2code.ecommerce.extensions

import com.luv2code.ecommerce.dto.Purchase
import com.luv2code.ecommerce.entity.Order
import java.util.UUID

fun Order.placeFromPurchase(purchase: Purchase): String
{
    val orderTrackingNumber = UUID.randomUUID().toString()
    this.orderTrackingNumber = orderTrackingNumber
    this.billingAddress = purchase.billingAddress
    this.shippingAddress = purchase.shippingAddress

    return orderTrackingNumber
}