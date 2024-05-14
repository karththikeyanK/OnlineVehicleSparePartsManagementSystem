package com.ovspms.model;

public class product {
    private int id;
    private String productName;
    private String model;
    private double price;

    public product(int id, String productName, String model, double price) {
        this.id = id;
        this.productName = productName;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
