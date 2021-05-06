/*
package nl.novi.springboot.first_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "studentcursus")
public class CustomerCursus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties("student_cursus")
    private Customer student;

    @ManyToOne
    @MapsId("cursusId")
    @JoinColumn(name = "cursus_id")
    @JsonIgnoreProperties("student_cursus")
    private Cursus cursus;

    @Column
    private int cijfer;

    // getters & settters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getStudent() {
        return student;
    }

    public void setStudent(Customer customer) {
        this.student = customer;
    }

    public Cursus getCursus() {
        return cursus;
    }

    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }

    public int getCijfer() {
        return cijfer;
    }

    public void setCijfer(int cijfer) {
        this.cijfer = cijfer;
    }
}

# in data.sql
INSERT INTO studentcursus (student_id, cursus_id, cijfer)
VALUES
(1, 1, 9),
(1, 2, 8);

 */
