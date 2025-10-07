package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository


// json entry - web path
interface ProductCategoryRepository : JpaRepository<ProductCategory, Long>
