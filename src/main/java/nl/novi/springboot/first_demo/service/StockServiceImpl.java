package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.exception.RecordNotFoundException;
import nl.novi.springboot.first_demo.model.Stock;
import nl.novi.springboot.first_demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    /*
    @Override
    public List<Stock> getAllCustomer() {
        return StockRepository.findAll();
    }
     */

    @Override
    public List<Stock> getStockByName(String name) {
        if (name == null || name.isEmpty())
            return stockRepository.findAll();
        else
            return stockRepository.findByItemNameStartingWithOrderByItemName(name);
    }

    @Override
    public Stock getStockById(long id) {
        if (stockRepository.existsById(id)) {
            return stockRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addStock(Stock stock) {
        Stock newStock = stockRepository.save(stock);
        return newStock.getId();
    }

    @Override
    public void deleteStock(long id) {
        if (stockRepository.existsById(id)) {
            stockRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateStock(long id, Stock stock) {
        if (stockRepository.existsById(id)) {
            Stock existingStock = stockRepository.findById(id).get();
            existingStock.setItem_name(stock.getItemName());
            existingStock.setPrice_in_euro(stock.getPrice_in_euro());
            existingStock.setStorage_location(stock.getStorage_location());
            existingStock.setPhone_number(stock.getPhone_number());
            stockRepository.save(existingStock);

        }
        else {
            throw new RecordNotFoundException();
        }
    }
}
