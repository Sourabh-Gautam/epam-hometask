package com.epam.quizapp.util;

import com.epam.quizapp.service.Service;

public class Request<T, E> {

	public Response<T, E> send(RequestData<T, T> requestData, Service<T, E> service) {
		return service.init(requestData);
	}

	public static <T, E>Request<T, E> getInstance() {
		return new Request<T, E>();
	}
}
