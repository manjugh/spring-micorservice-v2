package com.example.learning.controller.resilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ResilienceController {


    @GetMapping("/retry")
    //@Retry(name = "default")
    @Retry(name = "retryEx", fallbackMethod = "retryDefaultResponse")
    public String retry() {
        System.out.println("Retrying service procesing");
        new RestTemplate().getForEntity("http://localhost:9000", String.class);
        return "retry sucess";
    }

    @CircuitBreaker(name = "circuitbreaker",fallbackMethod = "circuitBreakerDefaultResponse")
    @GetMapping("/circuitbreaker")
    public String circuitBreaker(){
        new RestTemplate().getForEntity("http://localhost:9000", String.class);
        return "Test circuit breaker";
    }

    private String retryDefaultResponse(Exception exception) {
        return "defautl retry response";
    }

    private String circuitBreakerDefaultResponse(Exception exception) {
        return "defautl circuitbreaker response";
    }
}
