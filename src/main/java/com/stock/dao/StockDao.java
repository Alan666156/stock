package com.stock.dao;

import com.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StockDao extends JpaRepository<Stock, Long> {
	
	List<Stock> findByCode(String code);
}
