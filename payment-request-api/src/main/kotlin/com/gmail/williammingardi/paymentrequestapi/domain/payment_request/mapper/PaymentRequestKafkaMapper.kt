package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import com.gmail.williammingardi.paymentrequestapi.commons.Mapper
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.dto.PaymentRequestKafka
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.model.PaymentRequest
import org.springframework.stereotype.Component


@Component
class PaymentRequestKafkaMapper : Mapper<PaymentRequest, PaymentRequestKafka> {
    override fun map(t: PaymentRequest): PaymentRequestKafka {
        return PaymentRequestKafka(
            id = t.id,
            customerId = t.customerId,
            type = t.type,
            valueCents = t.valueCents,
            paymentReference = t.paymentReference ?: throw Exception("Payment ref not found"),
            createdAt = t.createdAt,
            updatedAt = t.updatedAt
        )
    }
}