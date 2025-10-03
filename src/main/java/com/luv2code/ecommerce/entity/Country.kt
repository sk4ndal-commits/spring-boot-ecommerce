package com.luv2code.ecommerce.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Entity
@Table(name = "country")
class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @Column(name = "code")
    private var code: String? = null

    @Column(name = "name")
    private var name: String? = null

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    var states: MutableList<State?>? = null
}
