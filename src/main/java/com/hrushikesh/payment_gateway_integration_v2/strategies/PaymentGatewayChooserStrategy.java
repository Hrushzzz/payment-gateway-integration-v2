package com.hrushikesh.payment_gateway_integration_v2.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayChooserStrategy {

    @Autowired
    private Razorpay razorpayGateway;

    @Autowired
    private Stripe stripeGateway;

    private final double THRESHOLD_AMOUNT = 10000.0;

    public PaymentGateway getBestPaymentGateway(double amount, String currency) {

        // Logic 1: If it's not INR, always use Stripe (International)
        if (!"INR".equalsIgnoreCase(currency)) {
            return stripeGateway;
        }

        // Logic 2: If amount is high, use Stripe; otherwise, use Razorpay
        if (amount >= THRESHOLD_AMOUNT) {
            return stripeGateway;
        } else {
            return razorpayGateway;
        }
    }
}
