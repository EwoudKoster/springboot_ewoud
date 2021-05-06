package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Employee;
import java.util.List;

public interface employeeService {

    List<Employee> getCursussenByName(String name);
    Employee getCursusById(long id);

}