package com.epam.product;

import java.util.List;

public class Admin {
    public static void main(String[] args) {
        OrdersData ordersData = new OrdersData();
        List<Order> orderList=ordersData.getOrders().getOrders();
        
        orderList.stream()
        	.filter(e -> e.getCategory().equals("Baby"))
        	.sorted((a, b) -> (int)(a.getPrice() - b.getPrice()))
        	.forEach(e -> System.out.println(e.getItem() + " - "+e.getPrice()));
    }
}

