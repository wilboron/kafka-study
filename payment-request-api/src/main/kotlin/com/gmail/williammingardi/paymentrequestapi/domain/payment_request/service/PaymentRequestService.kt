package com.gmail.williammingardi.paymentrequestapi.domain.payment_request.service

import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.PaymentRequestKafkaMapper
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.dto.PaymentRequestKafka
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.model.PaymentRequest
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.repository.PaymentRequestRepository
import com.sksamuel.avro4k.Avro
import org.apache.avro.generic.GenericRecord
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
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

    private val LOG: Logger = LogManager.getLogger(PaymentRequestService::class.java)

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

        LOG.info(avroRecord.schema)
        LOG.info("Sending record to kafka: $paymentRequestKafka")
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