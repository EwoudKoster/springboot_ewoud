package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer();
    List<Customer> getCustomerByName(String name);
    Customer getCustomerById(long id);
    long addCustomer(Customer customers);
    void deleteCustomer(long id);
    void updateCustomer(long id, Customer customers);

}
