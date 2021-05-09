package nl.novi.springboot.first_demo.model;

import javax.persistence.*;

@Entity
@Table(name = "repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String itemName;

    @Column(length = 80)
    private String price_in_euro;

    @Column(length = 80)
    private String handeling;

    @Column(length = 80)
    private String status;


    // constructors
    public Repair() {
    }

    public Repair(long stock_id, String itemName, String Price, String handeling, String status) {
        this.id = stock_id;
        this.itemName = itemName;
        this.price_in_euro = Price;
        this.handeling = handeling;
        this.status = status;

    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName; }

    public void setItem_name(String itemName) {
        this.itemName = itemName;}

    public String getPrice_in_euro() {
        return price_in_euro;
    }

    public void setPrice_in_euro(String Price) {
        this.price_in_euro = Price;
    }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getHandeling() {
        return handeling;
    }

    public void setHandeling(String handeling) {
        this.handeling = handeling;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}