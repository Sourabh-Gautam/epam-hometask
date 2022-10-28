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
			
			List<Quiz> quizList = QuizDao.getInstance().getAllQuiz();
			responseData.setAttribute("data", quizList);
			
		}
		else if(action.equals("deleteQuiz")) {
			
			List<Quiz> quizList = QuizDao.getInstance().deleteQuiz(Integer.parseInt(quizId));
			responseData.setAttribute("data", quizList);
			
		}
		else if(action.equals("renameQuiz")) {
			
			String newQuizTitle = requestData.getAttribute("newQuizTitle");
			List<Quiz> quizList = QuizDao.getInstance().renameQuiz(Integer.parseInt(quizId), newQuizTitle);
			responseData.setAttribute("data", quizList);
			
		}
		else if(action.equals("addQuiz")) {
			
			String quizTitle = requestData.getAttribute("quizTitle");
			
			Quiz quiz = new Quiz();
			quiz.setQuizTitle(quizTitle);
			quiz.setQuestionList(null);
					
			List<Quiz> quizList = QuizDao.getInstance().addQuiz(quiz);
			responseData.setAttribute("data", quizList);
			
		}
		
		
		Response<String, List<Quiz>> response = Response.getInstance();
		response.setResponseData(responseData);
		return response;
	}
	
}