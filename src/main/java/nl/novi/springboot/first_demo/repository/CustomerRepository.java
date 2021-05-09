package nl.novi.springboot.first_demo.repository;


import nl.novi.springboot.first_demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByAchternaamStartingWithOrderByAchternaam(String name);

}