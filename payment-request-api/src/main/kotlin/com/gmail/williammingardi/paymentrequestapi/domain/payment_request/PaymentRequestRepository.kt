package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRequestRepository : JpaRepository<PaymentRequest, Long> {
    fun findByPaymentReference(reference: String?): PaymentRequest?
}