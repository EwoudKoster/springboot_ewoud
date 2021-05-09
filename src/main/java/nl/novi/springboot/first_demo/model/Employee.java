package nl.novi.springboot.first_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "emplyees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String job;

    @Column
    private String naam;

    @Column
    private String emplyee_number;

    @JsonIgnoreProperties("customer")

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmplyee_number() {
        return emplyee_number;
    }

    public void setEmplyee_number(String emplyee_number) {
        this.emplyee_number = emplyee_number;
    }
}
