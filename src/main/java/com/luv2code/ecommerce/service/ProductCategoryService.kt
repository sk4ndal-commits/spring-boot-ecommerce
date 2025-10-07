package com.luv2code.ecommerce.service

import com.luv2code.ecommerce.dao.ProductCategoryRepository
import com.luv2code.ecommerce.entity.ProductCategory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductCategoryService(private val productCategoryRepository: ProductCategoryRepository) {
    fun findAll(pageable: Pageable): Page<ProductCategory> =
        productCategoryRepository.findAll(pageable)
}

