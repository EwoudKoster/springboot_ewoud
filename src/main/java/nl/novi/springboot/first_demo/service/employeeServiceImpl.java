package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.exception.RecordNotFoundException;
import nl.novi.springboot.first_demo.model.Employee;
import nl.novi.springboot.first_demo.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService {

    @Autowired
    employeeRepository employeeRepository;

    @Override
    public List<Employee> getCursussenByName(String name) {
        if (name == null || name.isEmpty())
            return employeeRepository.findAll();
        else
            return employeeRepository.findByNaamStartingWithOrderByNaam(name);
    }

    @Override
    public Employee getCursusById(long id) {
        if (employeeRepository.existsById(id)) {
            return employeeRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
