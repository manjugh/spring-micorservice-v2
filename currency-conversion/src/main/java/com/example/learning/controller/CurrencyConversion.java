package com.example.learning.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyConversion {

    private long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalulcatedAmount;
    private String enviornment;

    public CurrencyConversion(long id, String from, String to, BigDecimal conversionMultiple, BigDecimal totalCalulcatedAmount, String enviornment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.totalCalulcatedAmount = totalCalulcatedAmount;
        this.enviornment = enviornment;
    }

    public CurrencyConversion() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getTotalCalulcatedAmount() {
        return totalCalulcatedAmount;
    }

    public void setTotalCalulcatedAmount(BigDecimal totalCalulcatedAmount) {
        this.totalCalulcatedAmount = totalCalulcatedAmount;
    }

    public String getEnviornment() {
        return enviornment;
    }

    public void setEnviornment(String enviornment) {
        this.enviornment = enviornment;
    }
}
