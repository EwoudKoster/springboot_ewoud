package nl.novi.springboot.first_demo.repository;

import nl.novi.springboot.first_demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByItemNameStartingWithOrderByItemName(String name);

}

