package com.luv2code.ecommerce.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

import java.math.BigDecimal

@Entity
@Table(name = "order_item")
@Getter
@Setter
class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @Column(name = "image_url")
    private var imageUrl: String? = null

    @Column(name = "quantity")
    private var quantity: Integer? = null

    @Column(name = "unit_price")
    private var unitPrice: BigDecimal? = null

    @Column(name = "product_id")
    private var productId: Long? = null

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order? = null
}
