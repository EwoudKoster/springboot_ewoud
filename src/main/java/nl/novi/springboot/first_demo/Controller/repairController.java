package nl.novi.springboot.first_demo.Controller;

import nl.novi.springboot.first_demo.model.Repair;
import nl.novi.springboot.first_demo.model.Stock;
import nl.novi.springboot.first_demo.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class repairController {

    @Autowired
    RepairService repairService;

    @GetMapping(value = "/repair")
    public ResponseEntity<Object> getRepair(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(repairService.getRepairByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/repair/{id}")
    public ResponseEntity<Object> getRepair(@PathVariable("id") Integer id) {
        return  new ResponseEntity<>(repairService.getRepairById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/repair")
    public ResponseEntity<Object> addRepair(@RequestBody Repair repair) {

        long newId = repairService.addRepair(repair);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/repair/{id}")
    public ResponseEntity<Object> deleteRepair(@PathVariable("id") Integer id) {
        repairService.deleteRepair(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/repair/{id}")
    public ResponseEntity<Object> updateRepair(@PathVariable("id") Integer id, @RequestBody Repair repair) {
        repairService.updateRepair(id, repair);
        return new ResponseEntity<>("Record updated", HttpStatus.NO_CONTENT);
    }
}
