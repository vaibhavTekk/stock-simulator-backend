package com.project.stock_simulator.repository;

import com.project.stock_simulator.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
    Stock findBySymbol(String symbol);
}
