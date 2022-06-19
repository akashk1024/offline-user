package com.greatlearning.microservice.service;

import com.greatlearning.microservice.entity.Feedback;
import com.greatlearning.microservice.entity.Orders;
import com.greatlearning.microservice.entity.Payment;
import com.greatlearning.microservice.repository.FeedbackRepository;
import com.greatlearning.microservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderService orderService;

    public PaymentService(PaymentRepository paymentRepository, OrderService orderService){
        this.paymentRepository = paymentRepository;
        this.orderService = orderService;
    }

    public Payment save(Long orderId, Long amount) throws Exception {
        Orders orders = orderService.findByOrderId(orderId);
        Payment payment = Payment.builder().orders(orders).amount(amount).build();
        return paymentRepository.save(payment);
    }

}
