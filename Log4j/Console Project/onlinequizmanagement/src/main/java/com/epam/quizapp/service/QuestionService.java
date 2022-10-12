package com.epam.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.quizapp.dao.QuestionDao;
import com.epam.quizapp.model.Option;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class QuestionService implements Service<String, List<Question>> {

	@Override
	public Response<String, List<Question>> init(RequestData<String, String> requestData) {
		String action = requestData.getAttribute("action");
		String quizId = requestData.getAttribute("quizId");
		
		ResponseData<String, List<Question>> responseData = ResponseData.getInstance();
		
		if(action.equals("getQuestionList")) {
			List<Question> questionList = QuestionDao.getQuestionList(quizId);
			responseData.setAttribute("data", questionList);
		}
		else if(action.equals("deleteQuestion")) {
			String questionId = requestData.getAttribute("questionId");
			List<Question> questionList = QuestionDao.deleteQuestion(quizId, questionId);
			responseData.setAttribute("data", questionList);
		}
		else if(action.equals("addQuestion")) {
			String questionStatement = requestData.getAttribute("questionStatement");
			String option1 = requestData.getAttribute("option1");
			String option2 = requestData.getAttribute("option2");
			String option3 = requestData.getAttribute("option3");
			String option4 = requestData.getAttribute("option4");
			int correctOption = Integer.parseInt(requestData.getAttribute("correctOption"))-1;
			
			List<Option> optionList = new ArrayList<>();
			optionList.add(new Option("A", option1, false));
			optionList.add(new Option("B", option2, false));
			optionList.add(new Option("C", option3, false));
			optionList.add(new Option("D", option4, false));
			Option option = optionList.get(correctOption);
			option.setCorrect(true);
			optionList.set(correctOption, option);
			
			Question question = new Question("1", questionStatement, optionList);
			
			
			List<Question> questionList = QuestionDao.addQuestion(quizId, question);
			responseData.setAttribute("data", questionList);
		}
		
		Response<String, List<Question>> response = Response.getInstance();
		response.setResponseData(responseData);
		return response;
	}
	
}