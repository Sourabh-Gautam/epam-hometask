package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.quizapp.dao.QuestionDao;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.service.QuestionService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

@ExtendWith(value = { MockitoExtension.class })
class QuestionServiceTest {
	
	@Mock
	private QuestionDao questionDao;
	
	RequestData<String, String> requestData;
	
	List<Question> mockQuestionList;
	
	@BeforeEach
	void supplyRequestDataObj() {
		requestData = RequestData.getInstance();
		
		Question question = new Question();
		question.setId(1);
		question.setQuestionStatement("Who is the smallest planet ?");
		mockQuestionList = new ArrayList<>();
		mockQuestionList.add(question);
	}

	@Test
	void getQuestionListTest() {
		
		when(questionDao.getQuestionList(1)).thenReturn(mockQuestionList);
		
		requestData.setAttribute("action", "getQuestionList");
		requestData.setAttribute("quizId", "1");
		
		Response<String, List<Question>> response = new QuestionService(questionDao).init(requestData);
		ResponseData<String, List<Question>> responseData = response.getResponseData();
		
		int newQuestionCount = responseData.getAttribute("data").size();
		
		assertEquals(1, newQuestionCount);
	}
	
	
	@Test
	void addQuestionTest() {
		
		when(questionDao.addQuestion(anyInt(), any(Question.class))).thenReturn(mockQuestionList);

		requestData.setAttribute("action", "addQuestion");
		requestData.setAttribute("quizId", "1");
		requestData.setAttribute("questionStatement", "Who is the smallest planet ?");
		requestData.setAttribute("option1", "Mars");
		requestData.setAttribute("option2", "Mercury");
		requestData.setAttribute("option3", "Saturn");
		requestData.setAttribute("option4", "Venus");
		requestData.setAttribute("correctOption", "2");
		
		Response<String, List<Question>> response = new QuestionService(questionDao).init(requestData);
		ResponseData<String, List<Question>> responseData = response.getResponseData();
		
		int questionCountAfterAdd = responseData.getAttribute("data").size();
		
		assertEquals(1, questionCountAfterAdd);
	}
	
	@Test
	void deleteQuestionTest() {

		when(questionDao.deleteQuestion(1, 2)).thenReturn(mockQuestionList);
		
		requestData.setAttribute("action", "deleteQuestion");
		requestData.setAttribute("quizId", "1");
		requestData.setAttribute("questionId", "2");
		
		Response<String, List<Question>> response = new QuestionService(questionDao).init(requestData);
		ResponseData<String, List<Question>> responseData = response.getResponseData();
		
		int questionCountAfterDelete = responseData.getAttribute("data").size();
		
		assertEquals(1, questionCountAfterDelete);
	}
	
}
