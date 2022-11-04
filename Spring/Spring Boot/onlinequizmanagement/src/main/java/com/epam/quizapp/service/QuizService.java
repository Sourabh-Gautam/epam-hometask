package com.epam.quizapp.service;

import java.util.List;

import com.epam.quizapp.dao.QuizDao;
import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

@org.springframework.stereotype.Service
public class QuizService implements Service<String, List<Quiz>> {
	
	private QuizDao quizDao;
	
	public QuizService(QuizDao quizDao) {
		this.quizDao = quizDao;
	}

	@Override
	public Response<String, List<Quiz>> init(RequestData<String, String> requestData) {
		
		String action = requestData.getAttribute("action");
		String quizId = requestData.getAttribute("quizId");
		
		ResponseData<String, List<Quiz>> responseData = ResponseData.getInstance();
		
		switch(action) {
			case "getQuizList" : {
				List<Quiz> quizList = quizDao.getAllQuiz();
				responseData.setAttribute("data", quizList);
				break;
			}
			case "deleteQuiz" : {
				List<Quiz> quizList = quizDao.deleteQuiz(Integer.parseInt(quizId));
				responseData.setAttribute("data", quizList);
				break;
			}
			case "renameQuiz" : {
				String newQuizTitle = requestData.getAttribute("newQuizTitle");
				List<Quiz> quizList = quizDao.renameQuiz(Integer.parseInt(quizId), newQuizTitle);
				responseData.setAttribute("data", quizList);
				break;
			}
			case "addQuiz" : {
				String quizTitle = requestData.getAttribute("quizTitle");
				
				Quiz quiz = new Quiz();
				quiz.setQuizTitle(quizTitle);
				quiz.setQuestionList(null);
						
				List<Quiz> quizList = quizDao.addQuiz(quiz);
				responseData.setAttribute("data", quizList);
				break;
			}
			default: break;

		}		
		
		Response<String, List<Quiz>> response = Response.getInstance();
		response.setResponseData(responseData);
		return response;
	}
		
}