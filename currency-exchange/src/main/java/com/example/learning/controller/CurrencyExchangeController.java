package com.example.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange exchange(@PathVariable("from") String from, @PathVariable("to") String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        //CurrencyExchange currencyEchange = new CurrencyExchange(1001, from, to, BigDecimal.valueOf(80));
        currencyExchange.setEnviornment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
