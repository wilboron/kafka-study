package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime

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
    val createdAt: OffsetDateTime?,
    val updatedAt: OffsetDateTime?
)