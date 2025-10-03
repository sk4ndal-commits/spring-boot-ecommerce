package com.luv2code.ecommerce.entity

import jakarta.persistence.*
import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "product")
@Data
class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private val category: ProductCategory? = null

    @Column(name = "sku")
    private var sku: String? = null

    @Column(name = "name")
    private var name: String? = null

    @Column(name = "description")
    private var description: String? = null

    @Column(name = "unit_price")
    private var unitPrice: BigDecimal? = null

    @Column(name = "image_url")
    private var imageUrl: String? = null

    @Column(name = "active")
    private var active: Boolean? = null

    @Column(name = "units_in_stock")
    private var unitsInStock: Int? = null

    @Column(name = "date_created")
    @CreationTimestamp
    private var dateCreated: Date? = null

    @Column(name = "last_updated")
    @UpdateTimestamp
    private var lastUpdated: Date? = null
}
