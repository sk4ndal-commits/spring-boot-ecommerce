package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.PaymentInfo;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.service.ICheckoutService;


//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
  
  private final ICheckoutService checkoutService;

  public CheckoutController(ICheckoutService checkoutService) {
    this.checkoutService = checkoutService;
  }

  @PostMapping("/purchase")
  public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
    return checkoutService.placeOrder(purchase);
  }

  @PostMapping("/payment-intent")
  public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {
    PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);
    String paymentString = paymentIntent.toJson();
    return new ResponseEntity<>(paymentString, HttpStatus.OK);
  }
  
}
