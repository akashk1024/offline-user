package com.greatlearning.microservice.controller;

import com.greatlearning.microservice.entity.Payment;
import com.greatlearning.microservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/cash")
    public ResponseEntity<Payment> usingCash(@RequestParam Long orderId, @RequestParam Long amount) {
        try {
            Payment payment = paymentService.save(orderId, amount);
            return new ResponseEntity<>(payment, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/card")
    public ResponseEntity<Payment> addItems(@RequestParam Long orderId, @RequestParam Long amount) {
        try {
            Payment payment = paymentService.save(orderId, amount);
            return new ResponseEntity<>(payment, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
