package nl.novi.springboot.first_demo.Controller;

import nl.novi.springboot.first_demo.model.Customer;
import nl.novi.springboot.first_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity<Object> getCustomer(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") Integer id) {
        return  new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {

        long newId = customerService.addCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>("Record updated", HttpStatus.NO_CONTENT);
    }
}