package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "payment_requests")
class PaymentRequest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "customer_id", nullable = false)
    var customerId: String? = null,

    @Column(name = "type", nullable = false)
    var type: String? = null,

    @Column(name = "status", nullable = false)
    var status: String? = "pending",

    @Column(name = "value_cents", nullable = false)
    var valueCents: Long? = null,

    @Column(name = "payment_reference", nullable = false)
    var paymentReference: String? = null,

    @CreationTimestamp
    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
)