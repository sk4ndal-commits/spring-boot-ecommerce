package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.Customer

import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>
{
    fun findByEmail(email: String): Customer
}
