package com.luv2code.ecommerce.service

import com.luv2code.ecommerce.dao.ProductRepository
import com.luv2code.ecommerce.entity.Product
import com.luv2code.ecommerce.entity.ProductCategory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.math.BigDecimal

@ExtendWith(SpringExtension::class)
@DataJpaTest
@Import(ProductService::class)
open class ProductServiceTest {

    @Autowired
    lateinit var service: ProductService

    @Autowired
    lateinit var repository: ProductRepository

    @Autowired
    lateinit var categoryRepository: com.luv2code.ecommerce.dao.ProductCategoryRepository

    @Test
    fun `findAll should return empty list if repository is empty`() {
        val result = service.findAll(PageRequest.of(0, 10))
        assertThat(result.content).isEmpty()
    }

    @Test
    fun `findByCategoryId should return empty list if no products exist for category`() {
        val result = service.findByCategoryId(999, PageRequest.of(0, 10))
        assertThat(result.content).isEmpty()
    }

    @Test
    fun `findByNameContaining should return empty list if no products match`() {
        val result = service.findByNameContaining("notfound", PageRequest.of(0, 10))
        assertThat(result.content).isEmpty()
    }

    @Test
    fun `findAll should return products after saving`() {
        val category = categoryRepository.save(ProductCategory().apply {
            categoryName = "Test Category"
        })
        val product = Product().apply {
            name = "Test Product"
            sku = "SKU-123"
            unitPrice = BigDecimal("9.99")
            this.category = category
        }
        repository.save(product)
        val result = service.findAll(PageRequest.of(0, 10))
        assertThat(result.content).hasSize(1)
        assertThat(result.content[0].name).isEqualTo("Test Product")
    }

    @Test
    fun `findByCategoryId should return products for category`() {
        val category = ProductCategory().apply {
            categoryName = "Test Category"
        }
        val savedCategory = categoryRepository.save(category)
        val product = Product().apply {
            name = "Category Product"
            sku = "SKU-CAT"
            unitPrice = BigDecimal("19.99")
            this.category = savedCategory
        }
        repository.save(product)
        val result = service.findByCategoryId(savedCategory.id ?: 0, PageRequest.of(0, 10))
        assertThat(result.content).hasSize(1)
        assertThat(result.content[0].name).isEqualTo("Category Product")
    }

    @Test
    fun `findByNameContaining should return products matching name`() {
        val category = categoryRepository.save(ProductCategory().apply {
            categoryName = "Test Category"
        })
        val product = Product().apply {
            name = "UniqueName"
            sku = "SKU-UNIQUE"
            unitPrice = BigDecimal("29.99")
            this.category = category
        }
        repository.save(product)
        val result = service.findByNameContaining("UniqueName", PageRequest.of(0, 10))
        assertThat(result.content).hasSize(1)
        assertThat(result.content[0].name).isEqualTo("UniqueName")
    }
}
