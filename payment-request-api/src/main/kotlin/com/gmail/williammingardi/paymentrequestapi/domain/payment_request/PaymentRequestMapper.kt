package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import com.gmail.williammingardi.paymentrequestapi.commons.Mapper
import org.springframework.stereotype.Component

@Component
class PaymentRequestResponseMapper : Mapper<PaymentRequest, PaymentRequestResponse> {
    override fun map(t: PaymentRequest): PaymentRequestResponse {
        return PaymentRequestResponse(
            id = t.id,
            customerId = t.customerId,
            type = t.type,
            valueCents = t.valueCents,
            paymentReference = t.paymentReference,
            createdAt = t.createdAt,
            updatedAt = t.updatedAt
        )
    }
}

@Component
class CreatePaymentRequestMapper : Mapper<CreatePaymentRequest, PaymentRequest> {
    override fun map(t: CreatePaymentRequest): PaymentRequest {
        return PaymentRequest(
            customerId = t.customerId,
            type = t.type,
            valueCents = t.valueCents,
            paymentReference = t.paymentReference,
        )
    }
}