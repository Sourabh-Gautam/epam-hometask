package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.service.QuizService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

class QuizServiceTest {
	
	RequestData<String, String> requestData;
	int quizCount;
	
	@BeforeEach
	void supplyRequestDataObj() {
		requestData = RequestData.getInstance();
	}

	@Test
	void getQuizListTest() {
		
		requestData.setAttribute("action", "getQuizList");
		
		Response<String, List<Quiz>> response = new QuizService().init(requestData);
		ResponseData<String, List<Quiz>> responseData = response.getResponseData();
		
		List<Quiz> quizList = responseData.getAttribute("data");
		
		assertEquals(quizCount, quizList.size());
	}
	
	@Test
	void renameQuizTest() {
		requestData.setAttribute("action", "renameQuiz");
		requestData.setAttribute("quizId", "2");
		requestData.setAttribute("newQuizTitle", "General Knowledge Quiz");
		
		@SuppressWarnings("unused")
		Response<String, List<Quiz>> response = new QuizService().init(requestData);
				
	}
	
	@Test
	void addQuizTest() {
		
		requestData.setAttribute("action", "addQuiz");
		requestData.setAttribute("quizId", "6");
		requestData.setAttribute("quizName", "Java Quiz");
		
		Response<String, List<Quiz>> response = new QuizService().init(requestData);
		ResponseData<String, List<Quiz>> responseData = response.getResponseData();
		
		int quizCountAfterAdd = responseData.getAttribute("data").size();
		
		assertEquals(quizCount+1, quizCountAfterAdd);
	}
	
	@Test
	void deleteQuizTest() {
		
		requestData.setAttribute("action", "deleteQuiz");
		requestData.setAttribute("quizId", "3");
		
		Response<String, List<Quiz>> response = new QuizService().init(requestData);
		ResponseData<String, List<Quiz>> responseData = response.getResponseData();
		
		int quizCountAfterDelete = responseData.getAttribute("data").size();
		
		assertEquals(quizCount, quizCountAfterDelete+1);
	}
	
}
