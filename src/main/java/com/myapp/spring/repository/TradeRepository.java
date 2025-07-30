package com.myapp.spring.repository;

import com.myapp.spring.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByTradeDate(LocalDate date);
}
