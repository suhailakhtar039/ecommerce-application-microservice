package com.ecommerce.order.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Value("${app.message}")
    private String message;

    @GetMapping("/message")
    @Retry(name = "retryBreaker", fallbackMethod = "fallbackRetry")
    public String getMessage(){
        return message;
    }


}
