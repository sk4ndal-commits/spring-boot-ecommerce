package com.luv2code.ecommerce.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "customer")
@Getter
@Setter
class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @Column(name = "first_name")
    private var firstName: String? = null

    @Column(name = "last_name")
    private var lastName: String? = null

    @Column(name = "email")
    var email: String? = null

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL])
    private var orders: MutableSet<Order?>? = HashSet()

    fun add(order: Order?)
    {
        if (order != null)
        {
            if (this.orders == null)
            {
                this.orders = HashSet()
            }
            this.orders!!.add(order)
            order.customer = this
        }
    }
}
