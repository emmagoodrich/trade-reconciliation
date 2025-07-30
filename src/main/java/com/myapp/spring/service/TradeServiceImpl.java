package com.myapp.spring.service;

import com.myapp.spring.domain.Trade;
import com.myapp.spring.repository.TradeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @Override
    @Cacheable(value = "trade",key = "#tradeId")
    public Optional<Trade> getTradeById(Long tradeId) {
        return tradeRepository.findById(tradeId);
    }

    @Override
    public Trade updateTrade(Long id, Trade trade) {
        Optional<Trade> optionalTrade = tradeRepository.findById(id);
        if (!optionalTrade.isPresent()) {
            return null;
        }
        Trade updatedTrade = optionalTrade.get();
        updatedTrade.setInstrument(trade.getInstrument());
        updatedTrade.setPrice(trade.getPrice());
        updatedTrade.setQuantity(trade.getQuantity());
        updatedTrade.setTradeDate(trade.getTradeDate());
        updatedTrade.setSourceSystem(trade.getSourceSystem());
        return tradeRepository.save(updatedTrade);
    }

    @Override
    public Trade addTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public void deleteTrade(Trade trade) {
        tradeRepository.delete(trade);
    }
}
