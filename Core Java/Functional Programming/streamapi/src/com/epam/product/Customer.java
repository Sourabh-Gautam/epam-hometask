package com.epam.product;

import java.util.List;

public class Customer {
    private String customerId;
    private List<Order> orders;
    private List<Address> addresses;

    public Customer(){

    }
    public Customer(String customerId, List<Order> orders, List<Address> addresses) {
        this.customerId = customerId;
        this.orders = orders;
        this.addresses = addresses;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
