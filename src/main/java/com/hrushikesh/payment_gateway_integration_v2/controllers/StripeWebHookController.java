package com.hrushikesh.payment_gateway_integration_v2.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*

/Stripe WebHook ---> called by stripe when payment is successful or failed.
We will receive the event, and then we can update our order status in our system accordingly.

POST / PUT
 */
@RestController
@RequestMapping("/api/stripewebhook")
public class StripeWebHookController {
    @PostMapping
    public void listenToStripe(@RequestBody String event){
        // parse the event and update the order status in our system accordingly
        System.out.println(event);
    }
}
