package nl.novi.springboot.first_demo.Controller;

import nl.novi.springboot.first_demo.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class employeeController {

    @Autowired
    employeeService employeeService;

    @GetMapping(value = "/emplyee")
    public ResponseEntity<Object> getEmployee(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(employeeService.getCursussenByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getCursusById(id), HttpStatus.OK);
    }

}