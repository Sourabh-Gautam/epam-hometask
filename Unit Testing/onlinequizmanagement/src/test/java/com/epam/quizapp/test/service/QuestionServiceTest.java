package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizapp.database.QuizCollection;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.service.QuestionService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

class QuestionServiceTest {
	
	RequestData<String, String> requestData;
	
	int questionCount;
	
	@BeforeEach
	void supplyRequestDataObj() {
		requestData = RequestData.getInstance();
		questionCount = QuizCollection.getInstance().getQuiz("1").getQuestionList().size();
	}

	@Test
	void getQuestionListTest() {
				
		requestData.setAttribute("action", "getQuestionList");
		requestData.setAttribute("quizId", "1");
		
		Response<String, List<Question>> response = new QuestionService().init(requestData);
		ResponseData<String, List<Question>> responseData = response.getResponseData();
		
		int newQuestionCount = responseData.getAttribute("data").size();
		
		assertEquals(questionCount, newQuestionCount);
	}
	
	
	@Test
	void addQuestionTest() {

		requestData.setAttribute("action", "addQuestion");
		requestData.setAttribute("quizId", "1");
		requestData.setAttribute("questionStatement", "Who is the smallest planet ?");
		requestData.setAttribute("option1", "Mars");
		requestData.setAttribute("option2", "Mercury");
		requestData.setAttribute("option3", "Saturn");
		requestData.setAttribute("option4", "Venus");
		requestData.setAttribute("correctOption", "2");
		
		Response<String, List<Question>> response = new QuestionService().init(requestData);
		ResponseData<String, List<Question>> responseData = response.getResponseData();
		
		int questionCountAfterAdd = responseData.getAttribute("data").size();
		
		assertEquals(questionCount+1, questionCountAfterAdd);
	}
	
	@Test
	void deleteQuestionTest() {

		requestData.setAttribute("action", "deleteQuestion");
		requestData.setAttribute("quizId", "1");
		requestData.setAttribute("questionId", "2");
		
		Response<String, List<Question>> response = new QuestionService().init(requestData);
		ResponseData<String, List<Question>> responseData = response.getResponseData();
		
		int questionCountAfterDelete = responseData.getAttribute("data").size();
		
		assertEquals(questionCount, questionCountAfterDelete+1);
	}
	
}
