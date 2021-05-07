package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Employee;
import java.util.List;

public interface employeeService {

    List<Employee> getEmployeesByName(String name);
    Employee getEmployeeById(long id);

}