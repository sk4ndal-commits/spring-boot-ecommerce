package com.luv2code.ecommerce.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "country")
class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "code")
    var code: String? = null

    @Column(name = "name")
    var name: String? = null

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    var states: MutableList<State?>? = null
}
