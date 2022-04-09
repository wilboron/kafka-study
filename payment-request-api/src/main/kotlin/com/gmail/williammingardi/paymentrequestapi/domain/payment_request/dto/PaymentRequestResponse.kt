package com.gmail.williammingardi.paymentrequestapi.domain.payment_request.dto

import com.sksamuel.avro4k.serializer.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
//TODO: Interessante todo dto ter na frente o dto
data class PaymentRequestResponse(
    val id: Long?,
    val customerId: String?,
    val type: String?,
    val valueCents: Long?,
    val paymentReference: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)
