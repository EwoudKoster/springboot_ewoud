package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.exception.RecordNotFoundException;
import nl.novi.springboot.first_demo.model.Repair;
import nl.novi.springboot.first_demo.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    RepairRepository repairRepository;

    @Override
    public List<Repair> getRepairByName(String name) {
        if (name == null || name.isEmpty())
            return repairRepository.findAll();
        else
            return repairRepository.findByItemNameStartingWithOrderByItemName(name);
    }

    @Override
    public Repair getRepairById(long id) {
        if (repairRepository.existsById(id)) {
            return repairRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addRepair(Repair repair) {
        Repair newStock = repairRepository.save(repair);
        return newStock.getId();
    }

    @Override
    public void deleteRepair(long id) {
        if (repairRepository.existsById(id)) {
            repairRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateRepair(long id, Repair repair) {
        if (repairRepository.existsById(id)) {
            Repair existingRepair = repairRepository.findById(id).get();
            existingRepair.setItem_name(repair.getItemName());
            existingRepair.setPrice_in_euro(repair.getPrice_in_euro());
            repairRepository.save(existingRepair);

        }
        else {
            throw new RecordNotFoundException();
        }
    }
}
