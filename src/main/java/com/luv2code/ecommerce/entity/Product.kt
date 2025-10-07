package com.luv2code.ecommerce.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "product")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    var category: ProductCategory? = null

    @Column(name = "sku")
    var sku: String? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "unit_price")
    var unitPrice: BigDecimal? = null

    @Column(name = "image_url")
    var imageUrl: String? = null

    @Column(name = "active")
    var active: Boolean? = null

    @Column(name = "units_in_stock")
    var unitsInStock: Int? = null

    @Column(name = "date_created")
    @CreationTimestamp
    var dateCreated: Date? = null

    @Column(name = "last_updated")
    @UpdateTimestamp
    var lastUpdated: Date? = null
}
