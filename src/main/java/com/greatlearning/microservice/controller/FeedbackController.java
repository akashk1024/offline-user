package com.greatlearning.microservice.controller;

import com.greatlearning.microservice.dto.ItemEntryDto;
import com.greatlearning.microservice.entity.Feedback;
import com.greatlearning.microservice.entity.Orders;
import com.greatlearning.microservice.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }


    @PostMapping("/feedback")
    public ResponseEntity<Feedback> addItems(@RequestParam Long orderId, @RequestParam String feedBack){
        try {
            Feedback feedback = feedbackService.save(orderId,feedBack );
            return new ResponseEntity<>(feedback, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
