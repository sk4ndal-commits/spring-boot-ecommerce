package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>
{
    fun findByCategory_Id(id: Long, pageable: Pageable): Page<Product>
    fun findByNameContaining( name: String, pageable: Pageable): Page<Product>
}
