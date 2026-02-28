package com.hrushikesh.payment_gateway_integration_v2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {
    Long amount;
    String currency;
    String orderId;
    String phoneNumber;
    String name;
    String email;
}
