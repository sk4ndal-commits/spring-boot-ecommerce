package com.luv2code.ecommerce.entity

import jakarta.persistence.*

@Entity
@Table(name = "state")
class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "country_id")
    var country: Country? = null
}
