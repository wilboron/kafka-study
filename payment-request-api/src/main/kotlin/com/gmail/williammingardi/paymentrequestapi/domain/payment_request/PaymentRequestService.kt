package com.gmail.williammingardi.paymentrequestapi.domain.payment_request

import com.sksamuel.avro4k.Avro
import org.apache.avro.generic.GenericRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PaymentRequestService(
    private val repository: PaymentRequestRepository,
    private val paymentRequestKafkaMapper: PaymentRequestKafkaMapper,
) {
    @Autowired
    lateinit var kafka: KafkaTemplate<String, GenericRecord>

    fun findById(id: Long): PaymentRequest {
        return repository.findByIdOrNull(id) ?: throw Exception("Payment not found")
    }

    fun findByReference(reference: String): PaymentRequest {
        return repository.findByPaymentReference(reference) ?: throw Exception("Payment not found")
    }

    fun sendToKafka(paymentRequest: PaymentRequest, topicName: String) {
        val paymentRequestKafka = paymentRequestKafkaMapper.map(paymentRequest)
        val avroRecord = Avro.default.toRecord(
            PaymentRequestKafka.serializer(),
            paymentRequestKafka
        )
        println("Sending record to kafka: $paymentRequestKafka")
        kafka.send(
            topicName,
            paymentRequestKafka.paymentReference,
            avroRecord
        )
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