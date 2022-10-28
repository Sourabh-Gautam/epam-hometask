package com.epam.quizapp.util;

public class Response<T, E> {

	private ResponseData<T, E> responseData;

	public ResponseData<T, E> getResponseData() {
		return responseData;
	}

	public Response<T, E> setResponseData(ResponseData<T, E> responseData) {
		this.responseData = responseData;
		return this;
	}
	
	public static <T, E>Response<T, E> getInstance() {
		return new Response<>();
	}
	
}
