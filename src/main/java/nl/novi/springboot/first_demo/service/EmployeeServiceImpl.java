package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.exception.RecordNotFoundException;
import nl.novi.springboot.first_demo.model.Employee;
import nl.novi.springboot.first_demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeesByName(String name) {
        if (name == null || name.isEmpty())
            return employeeRepository.findAll();
        else
            return employeeRepository.findByNaamStartingWithOrderByNaam(name);
    }

    @Override
    public Employee getEmployeeById(long id) {
        if (employeeRepository.existsById(id)) {
            return employeeRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee.getId();
    }

    @Override
    public void deleteEmployee(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            Employee existingEmployee = employeeRepository.findById(id).get();
            existingEmployee.setId(employee.getId());
            existingEmployee.setJob(employee.getJob());
            existingEmployee.setNaam(employee.getNaam());
            existingEmployee.setEmplyee_number(employee.getEmplyee_number());
            employeeRepository.save(existingEmployee);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
