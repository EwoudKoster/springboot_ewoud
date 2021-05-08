package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Repair;
import java.util.List;

public interface RepairService {

    List<Repair> getRepairByName(String name);
    Repair getRepairById(long id);
    long addRepair(Repair repair);
    void deleteRepair(long id);
    void updateRepair(long id, Repair repair);

}