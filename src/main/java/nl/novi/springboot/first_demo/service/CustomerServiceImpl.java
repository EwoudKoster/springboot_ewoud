package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.exception.RecordNotFoundException;
import nl.novi.springboot.first_demo.model.Customer;
import nl.novi.springboot.first_demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        if (name == null || name.isEmpty())
            return customerRepository.findAll();
        else
            return customerRepository.findByAchternaamStartingWithOrderByAchternaam(name);
    }

    @Override
    public Customer getCustomerById(long id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    @Override
    public void deleteCustomer(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateCustomer(long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            Customer existingCustomer = customerRepository.findById(id).get();
            existingCustomer.setVoornaam(customer.getVoornaam());
            existingCustomer.setAchternaam(customer.getAchternaam());
            existingCustomer.setWoonplaats(customer.getWoonplaats());
            existingCustomer.setTelefoonnummer(customer.getTelefoonnummer());
            customerRepository.save(existingCustomer);

        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
