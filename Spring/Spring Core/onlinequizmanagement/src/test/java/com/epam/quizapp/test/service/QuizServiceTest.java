package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.quizapp.dao.QuizDao;
import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.service.QuizService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

@ExtendWith(value = { MockitoExtension.class })
class QuizServiceTest {
	
	@Mock
	private QuizDao quizDao;
	
	RequestData<String, String> requestData;
	List<Quiz> mockQuizList;
	
	@BeforeEach
	void supplyRequestDataObj() {
		
		requestData = RequestData.getInstance();
		
		Quiz quiz = new Quiz();
		quiz.setId(1);
		quiz.setQuizTitle("Hindi Quiz");
		mockQuizList = new ArrayList<>();
		mockQuizList.add(quiz);
		
	}

	@Test
	void getAllQuizTest() {
		
		when(quizDao.getAllQuiz()).thenReturn(mockQuizList);
		
		requestData.setAttribute("action", "getQuizList");
		
		Response<String, List<Quiz>> response = new QuizService(quizDao).init(requestData);
		ResponseData<String, List<Quiz>> responseData = response.getResponseData();
		
		List<Quiz> quizList = responseData.getAttribute("data");
		
		assertEquals(1, quizList.size());
	}
	
	@Test
	void renameQuizTest() {
		
		when(quizDao.renameQuiz(1, "Hindi Quiz")).thenReturn(mockQuizList);
		
		requestData.setAttribute("action", "renameQuiz");
		requestData.setAttribute("quizId", "1");
		requestData.setAttribute("newQuizTitle", "Hindi Quiz");
		
		Response<String, List<Quiz>> response = new QuizService(quizDao).init(requestData);
		
		List<Quiz> quizList = response.getResponseData().getAttribute("data");
		Quiz quiz = quizList.get(0);
		
		assertEquals("Hindi Quiz", quiz.getQuizTitle());
				
	}
	
	@Test
	void addQuizTest() {
		
		when(quizDao.addQuiz(any(Quiz.class))).thenReturn(mockQuizList);
		
		requestData.setAttribute("action", "addQuiz");
		requestData.setAttribute("quizId", "1");
		requestData.setAttribute("quizName", "Hindi Quiz");
		
		Response<String, List<Quiz>> response = new QuizService(quizDao).init(requestData);
		ResponseData<String, List<Quiz>> responseData = response.getResponseData();
		
		int quizCountAfterAdd = responseData.getAttribute("data").size();
		
		assertEquals(1, quizCountAfterAdd);
	}
	
	@Test
	void deleteQuizTest() {
		
		when(quizDao.deleteQuiz(2)).thenReturn(mockQuizList);
		
		requestData.setAttribute("action", "deleteQuiz");
		requestData.setAttribute("quizId", "2");
		
		Response<String, List<Quiz>> response = new QuizService(quizDao).init(requestData);
		ResponseData<String, List<Quiz>> responseData = response.getResponseData();
		
		int quizCountAfterDelete = responseData.getAttribute("data").size();
		
		assertEquals(1, quizCountAfterDelete);
	}
	
}
