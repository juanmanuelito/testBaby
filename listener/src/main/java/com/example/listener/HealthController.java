package com.example.listener;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("health")
    public String healthCheck() {
        return "I'm healthy 1 2 3 4";
    }
}
