package com.campanarienzo.backend.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.campanarienzo.backend.dto.PaymentDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PaymentRequestProducer {
  @Autowired
  private AmqpTemplate amqpTemplate;

  @Value("${rabbitmq.exchange.payment-request}")
  private String exchange;

  @Value("${rabbitmq.routing-key.payment-request}")
  private String routingKey;

  private final ObjectMapper objectMapper = new ObjectMapper();

  public void integrate(PaymentDTO paymentDTO) throws JsonProcessingException {
    this.amqpTemplate.convertAndSend(
        this.exchange,
        this.routingKey,
        this.objectMapper.writeValueAsString(paymentDTO));
  }
}
