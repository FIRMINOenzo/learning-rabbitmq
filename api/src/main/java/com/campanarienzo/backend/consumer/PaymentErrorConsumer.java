package com.campanarienzo.backend.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

import com.campanarienzo.backend.facade.PaymentFacade;

public class PaymentErrorConsumer {
  @Autowired
  private PaymentFacade paymentFacade;

  @RabbitListener(queues = { "payment-response-error-queue" })
  public void receive(@Payload Message<String> message) {
    System.err.println("ERROR RECEIVED - " + LocalDateTime.now());

    String payload = String.valueOf(message.getPayload());
    this.paymentFacade.paymentError(payload);
  }
}
