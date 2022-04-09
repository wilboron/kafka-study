package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import com.gmail.williammingardi.paymentrequestapi.commons.Mapper
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.dto.PaymentRequestResponse
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.model.PaymentRequest
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
