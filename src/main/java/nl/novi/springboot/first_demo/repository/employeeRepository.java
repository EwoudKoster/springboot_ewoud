package nl.novi.springboot.first_demo.repository;

import nl.novi.springboot.first_demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface employeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNaamStartingWithOrderByNaam(String name);

}
