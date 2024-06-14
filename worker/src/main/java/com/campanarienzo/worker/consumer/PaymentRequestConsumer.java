package com.campanarienzo.worker.consumer;

import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.campanarienzo.worker.producer.PaymentErrorProducer;
import com.campanarienzo.worker.producer.PaymentSuccessProducer;

@Component
public class PaymentRequestConsumer {
  @Autowired
  private PaymentSuccessProducer successProducer;

  @Autowired
  private PaymentErrorProducer errorProducer;

  @RabbitListener(queues = { "payment-request-queue" })
  public void receiveMessage(@Payload Message<String> message) {
    System.out.println(message);

    if (new Random().nextBoolean()) {
      this.successProducer.generateResponse("Payment confirmed. | " + message);
    } else {
      this.errorProducer.generateResponse("Error in payment. | " + message);
    }
  }
}
