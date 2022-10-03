package com.epam.product;

import java.util.Arrays;
import java.util.List;

public class OrdersData {

    public Customer getOrders(){
        Order order1 = new Order("Electronics", "Iphone", 48000, 2);
        Order order2 = new Order("Electronics", "MacBook", 150000, 1);
        Order order3 = new Order("Electronics", "Sony Video Projector", 425000, 4);

        Order order4 = new Order("Women's Fashion", "Fast-Track Watch", 10000, 2);
        Order order5 = new Order("Women's Fashion", "Leather HandBag", 2500, 1);

        Order order6 = new Order("Men's Fashion", "T-Shirt", 5000, 5);
        Order order7 = new Order("Men's Fashion", "Reebok Shoes", 5000, 2);
        Order order8 = new Order("Men's Fashion", "Titan Watch", 4800, 1);

        Order order9 = new Order("Baby", "HeadBands", 200, 4);
        Order order10 = new Order("Baby", "Canvas Cap", 1200, 1);
        Order order11 = new Order("Baby", "Baby SunGlasses", 4200, 4);
        Order order12 = new Order("Baby", "iLearn Baby Toys", 19000, 11);
        Order order13 = new Order("Baby", "Montessori Toys", 8900, 2);

        Order order14 = new Order("Books", "Clean Code Principles", 1100, 1);
        Order order15 = new Order("Books", "Microservices", 2300, 2);
        Order order16 = new Order("Baby", "Design Patterns & Principles", 850, 1);


        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5, order6, order7, order8,
                order9, order10, order11, order12, order13, order14, order15, order16);

        Address address1 = new Address("Office", "Madhapur, Hitec City, Hyderabad");
        Address address2 = new Address("Home", "UDA Colony, House No: 160, Vijayawada");
        Address address3 = new Address("Temporary", "Gachibowli, Hyderabad");

        List<Address> addresses = Arrays.asList(address1, address2, address3);

        return new Customer("21989", orders, addresses);
    }
}
