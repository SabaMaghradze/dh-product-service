package com.dailyhaul.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController { // for just checking whether bus refresh works(if it updates configs)

    @Value("${app.message}") // from product-service.yml
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
