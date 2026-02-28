package com.hrushikesh.payment_gateway_integration_v2.services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface IPaymentService {
    public String generatePaymentLink(
            String orderId,
            Long amount,
            String currency,
            String phoneNumber,
            String name,
            String email) throws RazorpayException, StripeException;
}

/*
Adapter Pattern ::
bringing a layer between controller and service class

Strategy + Factory ::
Strategy is for choosing payment gateways.
 */