package com.campanarienzo.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campanarienzo.backend.dto.PaymentDTO;
import com.campanarienzo.backend.facade.PaymentFacade;

@RestController
@RequestMapping("/payment")
public class PaymentAPI {
  @Autowired
  private PaymentFacade paymentFacade;

  @PostMapping()
  public String processPayment(@RequestBody PaymentDTO paymentDTO) {
    return this.paymentFacade.requestPayment(paymentDTO);
  }
}
