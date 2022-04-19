package com.gmail.williammingardi.kafka.model

import java.time.LocalDateTime

data class PaymentRequestKafkaTemp(
    val id: Long?,
    val customerId: String?,
    val type: String?,
    val valueCents: Long?,
    val paymentReference: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)