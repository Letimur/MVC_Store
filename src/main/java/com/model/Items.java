package com.model;


import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
public class Items {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "PRODUCT")
    private String product;
    @Column(name = "SOLD")
    private String sold;
    @Column(name = "DATE")
    private String date;

    public Items() {
    }

    public Items(int id, String product, String sold, String date) {
        this.id = id;
        this.product = product;
        this.sold = sold;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
