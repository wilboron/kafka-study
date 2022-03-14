package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import com.sksamuel.avro4k.serializer.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

data class CreatePaymentRequest(
    val customerId: String,
    val type: String,
    val valueCents: Long,
    val paymentReference: String
)

data class PaymentRequestResponse(
    val id: Long?,
    val customerId: String?,
    val type: String?,
    val valueCents: Long?,
    val paymentReference: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)

@Serializable
data class PaymentRequestKafka(
    val id: Long?,
    val customerId: String?,
    val type: String?,
    val valueCents: Long?,
    val paymentReference: String,
    @Serializable(with = LocalDateTimeSerializer::class)
    val createdAt: LocalDateTime?,
    @Serializable(with = LocalDateTimeSerializer::class)
    val updatedAt: LocalDateTime?
)