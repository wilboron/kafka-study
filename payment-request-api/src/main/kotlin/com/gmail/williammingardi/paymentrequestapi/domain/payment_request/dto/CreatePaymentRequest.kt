package com.gmail.williammingardi.paymentrequestapi.domain.payment_request.dto

import com.sksamuel.avro4k.serializer.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

data class CreatePaymentRequest(
    val customerId: String,
    val type: String,
    val valueCents: Long,
    val paymentReference: String
)
