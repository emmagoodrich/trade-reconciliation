package com.myapp.spring.controller;

import com.myapp.spring.domain.Trade;
import com.myapp.spring.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("trade")
@RestController
public class TradeController {


    @Autowired
    private TradeService tradeService;

    @GetMapping
    public ResponseEntity<List<Trade>> getTrades() {
        return ResponseEntity.ok(tradeService.getAllTrades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable Long id) {
        Optional<Trade> trade = tradeService.getTradeById(id);
        if (!trade.isPresent()) {
            return null;
        }
        return ResponseEntity.ok(trade.get());
    }

    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
        return ResponseEntity.ok(tradeService.addTrade(trade));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Long id, @RequestBody Trade trade) {
        return ResponseEntity.ok(tradeService.updateTrade(id, trade));
    }

    @DeleteMapping
    public ResponseEntity<Trade> deleteTradeById(@PathVariable Long id) {
        Optional<Trade> trade = tradeService.getTradeById(id);
        if (!trade.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Trade toDelete = trade.get();
        tradeService.deleteTrade(toDelete);
        return ResponseEntity.ok(toDelete);
    }
}
