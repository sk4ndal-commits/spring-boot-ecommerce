package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Order
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource


@RepositoryRestResource
interface IOrderRepository : JpaRepository<Order?, Long?>
{
    fun findByCustomerEmailOrderByDateCreatedDesc(@Param("email") email: String?, pageable: Pageable?): Page<Order?>?
}
