package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PaymentRequestService(
    private val repository: PaymentRequestRepository
) {
    fun findById(id: Long): PaymentRequest {
        return repository.findByIdOrNull(id) ?: throw Exception("Payment not found")
    }

    fun findByReference(reference: String): PaymentRequest {
        return repository.findByPaymentReference(reference) ?: throw Exception("Payment not found")
    }

    fun save(paymentRequest: PaymentRequest): PaymentRequest {
        return repository.save(paymentRequest)
    }

    fun update(id: Long, paymentUpdate: PaymentRequest): PaymentRequest {
        val paymentRequest = repository.findByIdOrNull(id) ?: throw Exception("Author")
        paymentRequest.status = paymentUpdate.status
        repository.save(paymentRequest)
        return paymentRequest
    }
}