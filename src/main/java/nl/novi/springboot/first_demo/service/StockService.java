package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Customer;
import nl.novi.springboot.first_demo.model.Stock;

import java.util.List;

public interface StockService {

   // List<Stock> getAllCustomer();
    List<Stock> getStockByName(String name);
    Stock getStockById(long id);
    long addStock(Stock stock);
    void deleteStock(long id);
    void updateStock(long id, Stock stock);

}