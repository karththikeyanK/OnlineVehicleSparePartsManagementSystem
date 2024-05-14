package com.ovspms.model;

public class Product {
    private int id;
    private String productName;
    private String model;
    private double price;

    public Product(int id, String productName, String model, double price) {
        this.id = id;
        this.productName = productName;
        this.model = model;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
