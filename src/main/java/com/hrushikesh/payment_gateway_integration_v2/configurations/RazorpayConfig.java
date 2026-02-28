package com.hrushikesh.payment_gateway_integration_v2.configurations;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        // Initialize Razorpay client with API key and secret
        return new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }
}

/*
This client object is part of dependency we added.
But don't we need to create spring bean and inject it wherever required?

Using this client object, we are going to call Razorpay apis?
RestTemplate.getForObject()

Payment service will call Razorpay
 */