package com.example.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("currency-conversion/from/{from}/to/{to}/{quantity}")
    public CurrencyConversion conversion(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        ResponseEntity<CurrencyConversion> currencyConversionResponseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, Map.of("from", from, "to", to));
        CurrencyConversion currencyConversion = currencyConversionResponseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(), quantity, BigDecimal.valueOf(quantity * currencyConversion.getConversionMultiple().intValue()), "");
    }

    @GetMapping("currency-conversion-feign/from/{from}/to/{to}/{quantity}")
    public CurrencyConversion conversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        CurrencyConversion currencyConversion = currencyExchangeProxy.conversion(from, to);

        return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(), quantity, BigDecimal.valueOf(quantity * currencyConversion.getConversionMultiple().intValue()), currencyConversion.getEnviornment());
    }
}
