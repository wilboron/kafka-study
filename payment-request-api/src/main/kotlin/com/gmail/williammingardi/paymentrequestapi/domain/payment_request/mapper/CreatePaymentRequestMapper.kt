package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import com.gmail.williammingardi.paymentrequestapi.commons.Mapper
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.dto.CreatePaymentRequest
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.model.PaymentRequest
import org.springframework.stereotype.Component

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
