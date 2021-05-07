package nl.novi.springboot.first_demo.Controller;

import nl.novi.springboot.first_demo.model.Stock;
import nl.novi.springboot.first_demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class stockController {

    @Autowired
    StockService stockService;

    @GetMapping(value = "/stock")
    @PreAuthorize("BACKOFFICE")
    public ResponseEntity<Object> getStock(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(stockService.getStockByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/stock/{id}")
    @PreAuthorize("BACKOFFICE")
    public ResponseEntity<Object> getStock(@PathVariable("id") Integer id) {
        return  new ResponseEntity<>(stockService.getStockById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/stock")
    @PreAuthorize("BACKOFFICE")
    public ResponseEntity<Object> addStock(@RequestBody Stock stock) {

        long newId = stockService.addStock(stock);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/stock/{id}")
    @PreAuthorize("BACKOFFICE")
    public ResponseEntity<Object> deleteStock(@PathVariable("id") Integer id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/stock/{id}")
    @PreAuthorize("BACKOFFICE")
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Integer id, @RequestBody Stock stock) {
        stockService.updateStock(id, stock);
        return new ResponseEntity<>("Record updated", HttpStatus.NO_CONTENT);
    }
}
