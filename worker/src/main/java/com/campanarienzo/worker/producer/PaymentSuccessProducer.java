package com.campanarienzo.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class PaymentSuccessProducer {
  @Autowired
  private AmqpTemplate amqpTemplate;

  @Value("${rabbitmq.exchange.payment-response-success}")
  private String exchange;

  @Value("${rabbitmq.routing-key.payment-response-success}")
  private String routingKey;

  public void generateResponse(String message) {
    this.amqpTemplate.convertAndSend(
        this.exchange,
        this.routingKey,
        message);
  }
}
