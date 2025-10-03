package com.luv2code.ecommerce.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

// choose Getter/Setter, Data has in OneToMany relationships a bug
@Entity
@Table(name = "product_category")
@Getter
@Setter
class ProductCategory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @Column(name = "category_name")
    private var categoryName: String? = null

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "category")
    private val products: MutableSet<Product?>? = null
}
