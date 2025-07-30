package com.myapp.spring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradeId;
    private String instrument;
    private double quantity;
    private double price;
    private LocalDate tradeDate;
    private String sourceSystem;

    public Trade() {
    }

    public Trade(String tradeId, String instrument, double quantity, double price, LocalDate tradeDate, String sourceSystem) {
        this.tradeId = tradeId;
        this.instrument = instrument;
        this.quantity = quantity;
        this.price = price;
        this.tradeDate = tradeDate;
        this.sourceSystem = sourceSystem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }
}
