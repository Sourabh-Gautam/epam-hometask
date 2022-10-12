package com.epam.quizapp.util;

import java.util.HashMap;

public class ResponseData<T, E> {

	private HashMap<T, E> hashmap = new HashMap<>();
	
	public ResponseData<T, E> setAttribute(T key, E value) {
		hashmap.put(key, value);
		return ResponseData.getInstance();
	}
	
	public E getAttribute(String key) {
		return hashmap.get(key);
	}
	
	public static <T, E>ResponseData<T, E> getInstance() {
		return new ResponseData<T, E>();
	}
	
}
