package com.campanarienzo.backend.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

import com.campanarienzo.backend.facade.PaymentFacade;

public class PaymentSuccessConsumer {
  @Autowired
  private PaymentFacade paymentFacade;

  @RabbitListener(queues = { "payment-response-success-queue" })
  public void receive(@Payload Message<String> message) {
    System.out.println("SUCCESS RECEIVED - " + LocalDateTime.now());

    String payload = String.valueOf(message.getPayload());
    this.paymentFacade.paymentSuccess(payload);
  }
}
