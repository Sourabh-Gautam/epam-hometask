package com.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("IN", "INDIA");
		map.put("AUS", "AUSTRALIA");
		map.put("UK", "ENGLAND");
		
		System.out.println(map);
		
		map.put("UK", "UNITED KINGDOM");
		
//		System.out.println(map);
//		
//		System.out.println(map.get("IN"));
//		System.out.println(map.containsKey("IN"));
//		System.out.println(map.containsValue("INDIA"));
//		System.out.println(map.size());
//		System.out.println(map.remove("UK"));
		
//		System.out.println(map);
		
//		System.out.println(map.values());
		
//		for(String country : map.values()) {
//			if(country.startsWith("I")) {
//				System.out.println(country);
//			}
//		}
		
//		System.out.println(map.keySet());
		
//		for(String countryCode : map.keySet()) {
//			System.out.println(map.get(countryCode));
//		}
		
//		System.out.println(map.entrySet());
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			
			if(entry.getKey().equals("UK")) {
				System.out.println(entry.getValue());
			}
		}
				
	}
}
