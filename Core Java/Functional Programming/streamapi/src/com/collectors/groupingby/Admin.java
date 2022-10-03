package com.collectors.groupingby;

import java.util.List;
import java.util.stream.Collectors;

public class Admin {
    public static void main(String[] args) {
        
    	Employee customer1 = new Employee("Sourabh", "D1");
    	Employee customer2 = new Employee("Rahul", "D1");
    	Employee customer3 = new Employee("Sumit", "D2");
    	Employee customer4 = new Employee("Deepak", "D3");
    	Employee customer5 = new Employee("Yogesh", "D3");
    	
        var list = List.of(customer1, customer2, customer3, customer4, customer5);
        
//        var items = list.stream().collect(Collectors.groupingBy(e -> e.getDept()));
//        System.out.println(items);
        
        var items = list.stream().collect(Collectors.groupingBy(e -> e.getDept(), Collectors.mapping(e -> e.getName(), Collectors.toList())));
        System.out.println(items);
    	
    }
}
	
