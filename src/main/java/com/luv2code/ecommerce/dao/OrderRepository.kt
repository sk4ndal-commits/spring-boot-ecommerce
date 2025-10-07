package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.Order
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin


@RepositoryRestResource
interface OrderRepository : JpaRepository<Order, Long>
{
    fun findByCustomerEmailOrderByDateCreatedDesc(email: String, pageable: Pageable): Page<Order>
}
