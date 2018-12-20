package com.model;

public class StockInfo {
    private int id;
    private String product;
    private int price;
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
