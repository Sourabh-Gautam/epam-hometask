package com.epam.quizapp.operation;

import java.util.List;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.service.QuestionService;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class QuestionOperation {
	private ResponseData<String, List<Question>> fetch(RequestData<String, String> requestData) {

		Request<String, List<Question>> request = Request.getInstance();
		Response<String, List<Question>> response = request.send(requestData, new QuestionService());
		ResponseData<String, List<Question>> responseData = response.getResponseData();

		return responseData;
		
	}

	public List<Question> getQuestions(String quizId) {
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("action", "getQuestionList");
		requestData.setAttribute("quizId", quizId);
		ResponseData<String, List<Question>> responseData = fetch(requestData);
		List<Question> questionList = responseData.getAttribute("data");

		return questionList;

	}
	
	public List<Question> deleteQuestion(String quizId, String questionId) {
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("action", "deleteQuestion");
		requestData.setAttribute("questionId", questionId);
		requestData.setAttribute("quizId", quizId);
		ResponseData<String, List<Question>> responseData = fetch(requestData);
		List<Question> questionList = responseData.getAttribute("data");

		return questionList;
		
	}

	public List<Question> addQuestion(String quizId, String questionStatement, String option1, String option2, String option3, String option4, String correctOption) {
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("action", "addQuestion");
		requestData.setAttribute("quizId", quizId);
		requestData.setAttribute("questionStatement", questionStatement);
		requestData.setAttribute("option1", option1);
		requestData.setAttribute("option2", option2);
		requestData.setAttribute("option3", option3);
		requestData.setAttribute("option4", option4);
		requestData.setAttribute("correctOption", correctOption);
		Request<String, List<Question>> request = Request.getInstance();
		Response<String, List<Question>> response = request.send(requestData, new QuestionService());
		ResponseData<String, List<Question>> responseData = response.getResponseData();
		return responseData.getAttribute("data");
	}

	public static QuestionOperation getInstance() {
		// TODO Auto-generated method stub
		return new QuestionOperation();
	}
}
