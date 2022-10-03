package com.epam.product;

public class Order {
    private String category;
    private String item;
    private double price;
    private int quantity;

    public Order(){

    }

    public Order(String category, String item, double price, int quantity) {
        this.category = category;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
