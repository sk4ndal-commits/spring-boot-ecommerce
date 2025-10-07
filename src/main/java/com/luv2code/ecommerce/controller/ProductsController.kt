package com.luv2code.ecommerce.controller

import com.luv2code.ecommerce.entity.Product
import com.luv2code.ecommerce.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductsController(private val productService: ProductService) {

    @GetMapping
    fun getAllProducts(pageable: Pageable): Page<Product> =
        productService.findAll(pageable)

    @GetMapping("/search/findByCategoryId")
    fun findByCategoryId(
        @RequestParam("id") categoryId: Long,
        pageable: Pageable
    ): Page<Product> = productService.findByCategoryId(categoryId, pageable)

    @GetMapping("/search/findByNameContaining")
    fun findByNameContaining(
        @RequestParam("name") name: String,
        pageable: Pageable
    ): Page<Product> = productService.findByNameContaining(name, pageable)

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<Product>
    {
        val product = productService.findById(id)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
