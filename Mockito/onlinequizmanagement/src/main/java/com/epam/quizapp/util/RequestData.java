package com.epam.quizapp.util;

import java.util.HashMap;

public class RequestData<T, E> {
	
	private HashMap<T, E> hashmap = new HashMap<>();
	
	public RequestData<T, E> setAttribute(T key, E value) {
		hashmap.put(key, value);
		return RequestData.getInstance();
	}
	
	public E getAttribute(T key) {
		return hashmap.get(key);
	}
	
	public static <T, E>RequestData<T, E> getInstance() {
		return new RequestData<>();
	}
	
}
