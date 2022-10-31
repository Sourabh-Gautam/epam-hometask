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
	
	private QuestionDao questionDao;
	
	public QuestionService(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public Response<String, List<Question>> init(RequestData<String, String> requestData) {
		String action = requestData.getAttribute("action");
		int quizId = Integer.parseInt(requestData.getAttribute("quizId"));
		
		ResponseData<String, List<Question>> responseData = ResponseData.getInstance();
		
		switch(action) {
		
			case "getQuestionList" : {
				List<Question> questionList = questionDao.getQuestionList(quizId);
				responseData.setAttribute("data", questionList);
				break;
			}
			case "deleteQuestion" : {
				int questionId = Integer.parseInt(requestData.getAttribute("questionId"));
				List<Question> questionList = questionDao.deleteQuestion(quizId, questionId);
				responseData.setAttribute("data", questionList);
				break;
			}
			case "addQuestion" : {
				String questionStatement = requestData.getAttribute("questionStatement");
				String option1 = requestData.getAttribute("option1");
				String option2 = requestData.getAttribute("option2");
				String option3 = requestData.getAttribute("option3");
				String option4 = requestData.getAttribute("option4");
				int correctOption = Integer.parseInt(requestData.getAttribute("correctOption"))-1;
				
				Question question = new Question();
				question.setQuestionStatement(questionStatement);
				
				List<Option> optionList = new ArrayList<>();
				
				Option optionObj1 = new Option();
				optionObj1.setOptionName(option1);
				optionObj1.setCorrect(false);
				optionObj1.setQuestion(question);
				
				Option optionObj2 = new Option();
				optionObj2.setOptionName(option2);
				optionObj2.setCorrect(false);
				optionObj2.setQuestion(question);
				
				Option optionObj3 = new Option();
				optionObj3.setOptionName(option3);
				optionObj3.setCorrect(false);
				optionObj3.setQuestion(question);
				
				Option optionObj4 = new Option();
				optionObj4.setOptionName(option4);
				optionObj4.setCorrect(false);
				optionObj4.setQuestion(question);
				
				
				optionList.add(optionObj1);
				optionList.add(optionObj2);
				optionList.add(optionObj3);
				optionList.add(optionObj4);
				
				Option option = optionList.get(correctOption);
				option.setCorrect(true);
				optionList.set(correctOption, option);
				
				
				question.setOptionList(optionList);			
				
				List<Question> questionList = questionDao.addQuestion(quizId, question);
				responseData.setAttribute("data", questionList);
			}
		
		}
		
		Response<String, List<Question>> response = Response.getInstance();
		response.setResponseData(responseData);
		return response;
	}
	
}