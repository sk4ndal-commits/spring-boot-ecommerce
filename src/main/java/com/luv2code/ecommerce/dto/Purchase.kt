package com.luv2code.ecommerce.dto

import com.luv2code.ecommerce.entity.Address
import com.luv2code.ecommerce.entity.Customer
import com.luv2code.ecommerce.entity.Order
import com.luv2code.ecommerce.entity.OrderItem
import lombok.Data

@Data
class Purchase
{
    val customer: Customer? = null
    val shippingAddress: Address? = null
    val billingAddress: Address? = null
    val order: Order? = null
    val orderItems: MutableSet<OrderItem?>? = null
}
