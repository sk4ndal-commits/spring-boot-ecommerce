package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource


// json entry - web path
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
interface IProductCategoryRepository : JpaRepository<ProductCategory?, Long?>
