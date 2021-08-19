package com.example.learning.limits.controller;

import com.example.learning.limits.configuration.LimitsConfiguration;
import com.example.learning.limits.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private LimitsConfiguration limitsConfiguration;

    @GetMapping("/limits")
    public Limits limits() {
        return new Limits(limitsConfiguration.getMinimum()+1, limitsConfiguration.getMaximum());
    }
}
