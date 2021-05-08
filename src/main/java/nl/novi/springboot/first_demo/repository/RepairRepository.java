package nl.novi.springboot.first_demo.repository;

import nl.novi.springboot.first_demo.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findByItemNameStartingWithOrderByItemName(String name);

}

