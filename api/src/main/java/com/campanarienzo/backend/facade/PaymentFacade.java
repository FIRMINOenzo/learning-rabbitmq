package com.campanarienzo.backend.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanarienzo.backend.dto.PaymentDTO;
import com.campanarienzo.backend.producer.PaymentRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PaymentFacade {
  @Autowired
  private PaymentRequestProducer producer;

  public String requestPayment(PaymentDTO paymentDTO) {
    try {
      this.producer.integrate(paymentDTO);
      return "Payment waiting confirmation.";
    } catch (JsonProcessingException e) {
      return "Error while requesting payment. " + e.getMessage();
    }
  }

  public void paymentError(String payload) {
    System.err.println("------\n PAYMENT ERROR:");
    System.err.println(payload);
    System.err.println("------");
  }

  public void paymentSuccess(String payload) {
    System.out.println("------\n PAYMENT SUCCESS:");
    System.out.println(payload);
    System.out.println("------");
  }
}