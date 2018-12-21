package com.model;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_TYPES")
public class StockInfo {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "PRODUCT")
    private String product;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "QUANTITY")
    private int quantity;

    public StockInfo(){
    }

    public StockInfo(int id, String product, int price, int quantity){
        this.id = id;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
}
