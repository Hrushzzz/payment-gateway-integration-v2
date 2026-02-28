package com.hrushikesh.payment_gateway_integration_v2.services;

import com.hrushikesh.payment_gateway_integration_v2.strategies.PaymentGateway;
import com.hrushikesh.payment_gateway_integration_v2.strategies.PaymentGatewayChooserStrategy;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    /*
   This is where I will choose between different options of Payment gateways
    */

    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    @Override
    public String generatePaymentLink(String orderId,
                                      Long amount,
                                      String currency,
                                      String phoneNumber,
                                      String name,
                                      String email) throws RazorpayException, StripeException {

        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.getBestPaymentGateway(amount, currency);
        return paymentGateway.generatePaymentLink(orderId, amount, phoneNumber, name, email);
    }
}
