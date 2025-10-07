package com.luv2code.ecommerce.entity

import jakarta.persistence.*

@Entity
@Table(name = "product_category")
class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "category_name")
    var categoryName: String? = null

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "category")
    @com.fasterxml.jackson.annotation.JsonManagedReference
    var products: MutableSet<Product> = mutableSetOf()
}
