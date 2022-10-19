package com.epam.quizapp.operation;

import java.util.List;

import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.service.QuizService;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class QuizOperation {
	
	private static final String ACTION = "action";
	private static final String QUIZID = "quizId";
	

	private ResponseData<String, List<Quiz>> fetch(RequestData<String, String> requestData) {

		Request<String, List<Quiz>> request = Request.getInstance();
		Response<String, List<Quiz>> response = request.send(requestData, new QuizService());
		return response.getResponseData();


	}

	public List<Quiz> createQuiz(String quizId, String quizName) {
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute(ACTION, "addQuiz");
		requestData.setAttribute(QUIZID, quizId);
		requestData.setAttribute("quizName", quizName);
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

}
