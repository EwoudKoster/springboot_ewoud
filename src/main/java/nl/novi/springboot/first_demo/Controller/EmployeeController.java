package nl.novi.springboot.first_demo.Controller;

import nl.novi.springboot.first_demo.model.Employee;
import nl.novi.springboot.first_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/emplyee")
    public ResponseEntity<Object> getEmployee(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        long newId = employeeService.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/employee/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
            employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>("Record updated", HttpStatus.NO_CONTENT);
    }

}