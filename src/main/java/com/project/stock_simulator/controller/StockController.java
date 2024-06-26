package com.project.stock_simulator.controller;

import com.project.stock_simulator.model.Stock;
import com.project.stock_simulator.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public List<String> getAllStockSymbols() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream()
                .map(Stock::getSymbol)
                .collect(Collectors.toList());
    }

    @GetMapping("/{symbol}")
    public Stock getStockBySymbol(@PathVariable String symbol) {
        return stockRepository.findBySymbol(symbol);
    }
}
