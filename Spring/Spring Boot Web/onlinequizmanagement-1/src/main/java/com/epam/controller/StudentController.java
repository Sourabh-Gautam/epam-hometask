package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.entity.Quiz;
import com.epam.exception.QuizNotFoundException;
import com.epam.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	StudentService studentService;

	public StudentController(StudentService service) {
		this.studentService = service;
	}
	
	@GetMapping("/showquiz")
	public ModelAndView showQuiz(HttpServletRequest request) {
		String quizId = request.getParameter("quizid");
		ModelAndView mv = new ModelAndView();

		try {
			Quiz quiz = studentService.getQuizById(Integer.parseInt(quizId));
			request.setAttribute("quiz", quiz);
			mv.setViewName("quizviewstudent");
		}catch (NumberFormatException | QuizNotFoundException e) {
			e.printStackTrace();
		}
		
		return mv;
				
	}
	
	
	@GetMapping("/getquizes")
	public ModelAndView getAllQuiz(HttpServletRequest request) {
		List<Quiz> quizList = studentService.getAllQuiz();
		request.setAttribute("quizList", quizList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentpage");
		return mv;
	}
	
}
