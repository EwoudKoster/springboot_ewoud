package nl.novi.springboot.first_demo.model;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String itemName;

    @Column(length = 80)
    private String price_in_euro;

    @Column(length = 80)
    private String storage_location;

    @Column(length = 20)
    private String phone_number;

    // constructors
    public Stock() {
    }

    public Stock(long stock_id, String itemName, String price_in_euro, String storage_location, String phone_number) {
        this.id = stock_id;
        this.itemName = itemName;
        this.price_in_euro = price_in_euro;
        this.storage_location = storage_location;
        this.phone_number = phone_number;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() { return itemName; }

    public void setItem_name(String itemName) { this.itemName = itemName;}

    public String getPrice_in_euro() {
        return price_in_euro;
    }

    public void setPrice_in_euro(String price_in_euro) {
        this.price_in_euro = price_in_euro;
    }

    public String getStorage_location() {
        return storage_location;
    }

    public void setStorage_location(String storage_location) {
        this.storage_location = storage_location;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}