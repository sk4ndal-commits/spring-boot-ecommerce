package com.luv2code.ecommerce.entity

import com.luv2code.ecommerce.dto.Purchase
import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.util.*


@Entity
@Table(name = "orders")
@Getter
@Setter
class Order
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Long? = null

    @Column(name = "order_tracking_number")
    var orderTrackingNumber: String? = null

    @Column(name = "total_price")
    private var totalPrice: BigDecimal? = null

    @Column(name = "total_quantity")
    private var totalQuantity: Integer? = null

    @Column(name = "status")
    private var status: String? = null

    @Column(name = "date_created")
    @CreationTimestamp
    private var dateCreated: Date? = null

    @Column(name = "last_updated")
    @UpdateTimestamp
    private var lastUpdated: Date? = null

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "order")
    var orderItems: MutableSet<OrderItem> = HashSet()

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    var shippingAddress: Address? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    var billingAddress: Address? = null

    fun add(item: OrderItem?)
    {
        if (item == null) return

        this.orderItems.add(item)
        item.order = this
    }
}
