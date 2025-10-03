package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface IProductRepository : JpaRepository<Product?, Long?>
{
    fun findByCategoryId(@Param("id") id: Long?, pageable: Pageable?): Page<Product?>?
    fun findByNameContaining(@Param("name") name: String?, pageable: Pageable?): Page<Product?>?
}
