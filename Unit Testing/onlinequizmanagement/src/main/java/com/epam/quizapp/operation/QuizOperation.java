package com.epam.quizapp.operation;

import java.util.List;

import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.service.QuizService;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class QuizOperation {

	private ResponseData<String, List<Quiz>> fetch(RequestData<String, String> requestData) {

		Request<String, List<Quiz>> request = Request.getInstance();
		Response<String, List<Quiz>> response = request.send(requestData, new QuizService());
		ResponseData<String, List<Quiz>> responseData = response.getResponseData();

		return responseData;

	}

	public List<Quiz> createQuiz(String quizId, String quizName) {
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("action", "addQuiz");
		requestData.setAttribute("quizId", quizId);
		requestData.setAttribute("quizName", quizName);
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		List<Quiz> quizList = responseData.getAttribute("data");

		return quizList;
	}

	public List<Quiz> deleteQuiz(String quizId) {
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("action", "deleteQuiz");
		requestData.setAttribute("quizId", quizId);
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		List<Quiz> quizList = responseData.getAttribute("data");

		return quizList;
	}

	public List<Quiz> renameQuiz(String quizId, String newQuizTitle) {
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("action", "renameQuiz");
		requestData.setAttribute("quizId", quizId);
		requestData.setAttribute("newQuizTitle", newQuizTitle);
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		List<Quiz> quizList = responseData.getAttribute("data");

		return quizList;
	}

	public static QuizOperation getInstance() {
		return new QuizOperation();
	}

	public List<Quiz> getQuizes() {
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("action", "getQuizList");
		ResponseData<String, List<Quiz>> responseData = fetch(requestData);
		List<Quiz> quizList = responseData.getAttribute("data");

		return quizList;

	}

}
