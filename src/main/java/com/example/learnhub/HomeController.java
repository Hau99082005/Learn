package com.example.learnhub;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
            "application", "LearnHub API",
            "status", "running",
            "endpoints", List.of(
                "GET /api/test",
                "GET /api/users",
                "GET /api/courses",
                "POST /api/auth/login"
            )
        );
    }
}
