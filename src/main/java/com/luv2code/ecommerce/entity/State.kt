package com.luv2code.ecommerce.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Entity
@Table(name = "state")
class State
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Long? = null


    @Column(name = "name")
    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "country_id")
    private val country: Country? = null
}
