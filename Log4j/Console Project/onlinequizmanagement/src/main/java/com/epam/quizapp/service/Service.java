package com.epam.quizapp.service;

import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;

public interface Service<T, E> {
	Response<T, E> init(RequestData<T, T> requestData);
}
