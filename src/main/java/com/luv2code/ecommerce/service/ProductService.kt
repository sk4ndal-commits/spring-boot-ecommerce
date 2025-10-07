package com.luv2code.ecommerce.service

import com.luv2code.ecommerce.dao.ProductRepository
import com.luv2code.ecommerce.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
open class ProductService(private val productRepository: ProductRepository) {
    fun findAll(pageable: Pageable): Page<Product> =
        productRepository.findAll(pageable)

    fun findByCategoryId(categoryId: Long, pageable: Pageable): Page<Product> =
        productRepository.findByCategory_Id(categoryId, pageable)

    fun findByNameContaining(name: String, pageable: Pageable): Page<Product> =
        productRepository.findByNameContaining(name, pageable)

    fun findById(id: Long): Product? =
        productRepository.findById(id).orElse(null)
}
