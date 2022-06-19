package com.greatlearning.microservice.service;

import com.greatlearning.microservice.entity.Feedback;
import com.greatlearning.microservice.entity.Orders;
import com.greatlearning.microservice.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    private final OrderService orderService;

    public FeedbackService(FeedbackRepository feedbackRepository, OrderService orderService) {
        this.feedbackRepository = feedbackRepository;
        this.orderService = orderService;
    }

    public Feedback save(Long orderId, String feedBack) throws Exception {
        Orders orders = orderService.findByOrderId(orderId);
        Feedback feedbackBean = Feedback.builder().orders(orders).feedback(feedBack).build();
        return feedbackRepository.save(feedbackBean);
    }

}
