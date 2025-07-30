package com.myapp.spring.service;

import com.myapp.spring.domain.Instrument;
import com.myapp.spring.domain.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeService {
    List<Trade> getAllTrades();
    Optional<Trade> getTradeById(Long id);
    Trade updateTrade(Long id, Trade trade);
    Trade addTrade(Trade trade);
    void deleteTrade(Trade trade);

}
