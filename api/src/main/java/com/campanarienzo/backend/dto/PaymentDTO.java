package com.campanarienzo.backend.dto;

import java.math.BigDecimal;

public record PaymentDTO(String order, BigDecimal value, String product) {
}
