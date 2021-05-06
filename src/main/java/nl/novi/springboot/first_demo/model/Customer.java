package nl.novi.springboot.first_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String voornaam;

    @Column(length = 80)
    private String achternaam;

    @Column(length = 80)
    private String woonplaats;

    @Column(length = 20)
    private String telefoonnummer;

    @JsonIgnoreProperties("customer")

    // constructors
    public Customer() {
    }

    public Customer(long customer_id, String voornaam, String achternaam, String woonplaats, String telefoonnummer) {
        this.id = customer_id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.woonplaats = woonplaats;
        this.telefoonnummer = telefoonnummer;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
}