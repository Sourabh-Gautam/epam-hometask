package com.epam.quizapp.operation;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.service.QuizService;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

@Component
public class QuizOperation implements ApplicationContextAware {
	
	ApplicationContext applicationContext;
	
	private static final String ACTION = "action";
	private static final String QUIZID = "quizId";
	

	private ResponseData<String, List<Quiz>> fetch(RequestData<String, String> requestData) {

		Request<String, List<Quiz>> request = Request.getInstance();
		Response<String, List<Quiz>> response = request.send(requestData, applicationContext.getBean(QuizService.class));
		return response.getResponseData();


	}

	public List<Quiz> createQuiz(String quizTitle) {
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute(ACTION, "addQuiz");
		requestData.setAttribute("quizTitle", quizTitle);
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		return responseData.getAttribute("data");

	}

	public List<Quiz> deleteQuiz(String quizId) {
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute(ACTION, "deleteQuiz");
		requestData.setAttribute(QUIZID, quizId);
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		return responseData.getAttribute("data");

	}

	public List<Quiz> renameQuiz(String quizId, String newQuizTitle) {
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute(ACTION, "renameQuiz");
		requestData.setAttribute(QUIZID, quizId);
		requestData.setAttribute("newQuizTitle", newQuizTitle);
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		return responseData.getAttribute("data");

	}

	public static QuizOperation getInstance() {
		return new QuizOperation();
	}

	public List<Quiz> getQuizes() {
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute(ACTION, "getQuizList");
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		return responseData.getAttribute("data");

	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
