package com.luv2code.ecommerce.controller

import com.luv2code.ecommerce.entity.ProductCategory
import com.luv2code.ecommerce.service.ProductCategoryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-category")
class ProductCategoryController(private val productCategoryService: ProductCategoryService) {

    @GetMapping
    fun getAllCategories(pageable: Pageable): Page<ProductCategory> =
        productCategoryService.findAll(pageable)
}

