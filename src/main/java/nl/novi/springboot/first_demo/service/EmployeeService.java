package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Customer;
import nl.novi.springboot.first_demo.model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeesByName(String name);
    Employee getEmployeeById(long id);
    long addEmployee(Employee employee);
    void deleteEmployee(long id);
    void updateEmployee(long id, Employee employee);

}