package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/payment_request")
class PaymentRequestController(
    private val service: PaymentRequestService,
    private val createPaymentRequestMapper: CreatePaymentRequestMapper,
    private val paymentRequestResponseMapper: PaymentRequestResponseMapper
) {
    // POST /payment_request
    @PostMapping
    @Transactional
    fun create(
        @RequestBody createRequest: CreatePaymentRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PaymentRequestResponse> {
        val paymentRequest = createPaymentRequestMapper.map(createRequest)
        val authorResponse = paymentRequestResponseMapper.map(service.save(paymentRequest))
        val uri = uriBuilder.path("/authors/${authorResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(authorResponse)
    }
}