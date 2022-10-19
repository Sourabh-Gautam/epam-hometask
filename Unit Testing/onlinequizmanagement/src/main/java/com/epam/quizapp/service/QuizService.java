package com.epam.quizapp.service;

import java.util.List;

import com.epam.quizapp.dao.QuizDao;
import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class QuizService implements Service<String, List<Quiz>> {

	@Override
	public Response<String, List<Quiz>> init(RequestData<String, String> requestData) {
		String action = requestData.getAttribute("action");
		String quizId = requestData.getAttribute("quizId");
		
		ResponseData<String, List<Quiz>> responseData = ResponseData.getInstance();
		
		if(action.equals("getQuizList")) {
			List<Quiz> quizList = QuizDao.getAllQuiz();
			responseData.setAttribute("data", quizList);
		}
		else if(action.equals("deleteQuiz")) {
			List<Quiz> quizList = QuizDao.deleteQuiz(quizId);
			responseData.setAttribute("data", quizList);
		}
		else if(action.equals("renameQuiz")) {
			String newQuizTitle = requestData.getAttribute("newQuizTitle");
			List<Quiz> quizList = QuizDao.renameQuiz(quizId, newQuizTitle);
			responseData.setAttribute("data", quizList);
		}
		else if(action.equals("addQuiz")) {
			String quizName = requestData.getAttribute("quizName");
			Quiz quiz = new Quiz(quizId, quizName, null);
			List<Quiz> quizList = QuizDao.addQuiz(quiz);
			responseData.setAttribute("data", quizList);
		}
		
		
		Response<String, List<Quiz>> response = Response.getInstance();
		response.setResponseData(responseData);
		return response;
	}
	
}