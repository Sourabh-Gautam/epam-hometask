package com.epam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.epam.entity.Option;
import com.epam.entity.Question;
import com.epam.entity.Quiz;
import com.epam.exception.QuizNotFoundException;
import com.epam.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	private static final String QUIZVIEWADMIN = "quizviewadmin";
	private static final String QUIZID = "quizid";

	AdminService service;

	public AdminController(AdminService service) {
		this.service = service;
	}

	@PostMapping("/createquiz")
	public ModelAndView createQuiz(HttpServletRequest request) {
		System.out.println("Hello from quiz cretion");
		String quizTitle = request.getParameter("quizname");
		Quiz quiz = Quiz.builder().quizTitle(quizTitle).build();
		Quiz quizdb = service.createQuiz(quiz);
		System.out.println(quizdb);
		String view = "createquizpage";
		if (quizdb != null) {
			view = "adminpage";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		return mv;

	}

	@GetMapping("/showquiz")
	public ModelAndView showQuiz(HttpServletRequest request) {
		String quizId = request.getParameter(QUIZID);
		ModelAndView mv = new ModelAndView();
		try {
			Quiz quiz = service.getQuizById(Integer.parseInt(quizId));
			request.setAttribute("quiz", quiz);
			mv.setViewName(QUIZVIEWADMIN);
		} catch (NumberFormatException | QuizNotFoundException e) {
			mv.setViewName("adminpage");
			e.printStackTrace();
		}

		return mv;

	}

	@PostMapping("/deletequiz")
	public ModelAndView deleteQuiz(HttpServletRequest request) {
		String quizId = request.getParameter(QUIZID);

		service.deleteQuizById(Integer.parseInt(quizId));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminpage");
		return mv;

	}

	@PostMapping("/deletequestion")
	public ModelAndView deleteQuestion(HttpServletRequest request) {
		String questionId = request.getParameter("questionid");
		int quizId = Integer.parseInt(request.getParameter(QUIZID));

		service.deleteQuestionById(Integer.parseInt(questionId));
		ModelAndView mv = new ModelAndView();
		try {
			Quiz quiz = service.getQuizById(quizId);
			request.setAttribute("quiz", quiz);
			mv.setViewName(QUIZVIEWADMIN);
		} catch (QuizNotFoundException e) {
			e.printStackTrace();
		}

		return mv;

	}

	@PostMapping("/addquestion")
	public ModelAndView addQuestion(HttpServletRequest request) {
		String questionStatement = request.getParameter("questionstatement");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		int quizId = Integer.parseInt(request.getParameter(QUIZID));

		int correctOption = Integer.parseInt(request.getParameter("correctoption")) - 1;

		Question question = new Question();
		question.setQuestionStatement(questionStatement);

		List<Option> optionList = new ArrayList<>();

		Option optionObj1 = new Option();
		optionObj1.setOptionName(option1);
		optionObj1.setCorrect(false);
		optionObj1.setQuestionId(question.getId());

		Option optionObj2 = new Option();
		optionObj2.setOptionName(option2);
		optionObj2.setCorrect(false);
		optionObj2.setQuestionId(question.getId());

		Option optionObj3 = new Option();
		optionObj3.setOptionName(option3);
		optionObj3.setCorrect(false);
		optionObj3.setQuestionId(question.getId());

		Option optionObj4 = new Option();
		optionObj4.setOptionName(option4);
		optionObj4.setCorrect(false);
		optionObj4.setQuestionId(question.getId());

		optionList.add(optionObj1);
		optionList.add(optionObj2);
		optionList.add(optionObj3);
		optionList.add(optionObj4);

		Option option = optionList.get(correctOption);
		option.setCorrect(true);
		optionList.set(correctOption, option);

		question.setOptionList(optionList);
		question.setQuizId(quizId);
		System.out.println(quizId);

		ModelAndView mv = new ModelAndView();
		
		System.out.println(question);
		
		service.addQuestion(question);
		try {
			Quiz quiz = service.getQuizById(quizId);
			request.setAttribute("quiz", quiz);
			mv.setViewName(QUIZVIEWADMIN);
		} catch (QuizNotFoundException e) {
			e.printStackTrace();
		}
		
		return mv;

	}

	@GetMapping("/createquizpage")
	public ModelAndView saveQuiz() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createquizpage");
		return mv;
	}

	@GetMapping("/operatequizpage")
	public ModelAndView getAllQuiz(HttpServletRequest request) {
		List<Quiz> quizList = service.getAllQuiz();
		request.setAttribute("quizList", quizList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("operatequizpage");
		return mv;
	}

}
