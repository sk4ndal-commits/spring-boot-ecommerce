package com.luv2code.ecommerce.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "address")
@Getter
@Setter
class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @Column(name = "street")
    private var street: String? = null

    @Column(name = "city")
    private var city: String? = null

    @Column(name = "state")
    private var state: String? = null

    @Column(name = "country")
    private var country: String? = null

    @Column(name = "zip_code")
    private var zipCode: String? = null

    @OneToOne
    @PrimaryKeyJoinColumn
    private val order: Order? = null
}
