package com.gmail.williammingardi.kafka.processor

import com.gmail.williammingardi.kafka.model.PaymentRequestKafkaTemp
import com.gmail.williammingardi.paymentrequestapi.domain.payment_request.dto.PaymentRequestKafka
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped
import io.quarkus.logging.Log;

@ApplicationScoped
class PaymentRequestProcessor {

    @Incoming("payment_requests")
    fun process(paymentRequest: PaymentRequestKafka) {
        Log.info("Received a kafka message!")
        Log.info(paymentRequest)
    }

}