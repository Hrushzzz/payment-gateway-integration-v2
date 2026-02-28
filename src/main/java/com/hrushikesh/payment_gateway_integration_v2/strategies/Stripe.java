package com.hrushikesh.payment_gateway_integration_v2.strategies;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Component;

@Component
public class Stripe implements PaymentGateway {
    @Override
    public String generatePaymentLink(String orderId, Long amount, String phoneNumber, String name, String email) throws RazorpayException, StripeException {
        return "";
    }
}
