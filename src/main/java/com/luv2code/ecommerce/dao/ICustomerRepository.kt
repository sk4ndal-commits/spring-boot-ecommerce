package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.Customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

interface ICustomerRepository : JpaRepository<Customer?, Long?>
{
    fun findByEmail(email: String?): Customer?
}
