package com.hrushikesh.payment_gateway_integration_v2.controllers;

import com.hrushikesh.payment_gateway_integration_v2.dtos.PaymentRequestDTO;
import com.hrushikesh.payment_gateway_integration_v2.services.IPaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
    /generatePaymentLink
    Type: POST
    Request:{
        "orderId": "12345",
    }
    Response: {
        "paymentLink": "https://paymentgateway.com/pay?orderId=12345&token=abcde"
    }

    Every orderId can itself act as idempotent key. This idempotency will be handled
    by PG assume.
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping
    public String generatePaymentLink(@RequestBody PaymentRequestDTO paymentRequestDTO) throws StripeException, RazorpayException {
        return paymentService.generatePaymentLink(paymentRequestDTO.getOrderId(),
                paymentRequestDTO.getAmount(),
                paymentRequestDTO.getCurrency(),
                paymentRequestDTO.getPhoneNumber(),
                paymentRequestDTO.getName(),
                paymentRequestDTO.getEmail());
    }
}
