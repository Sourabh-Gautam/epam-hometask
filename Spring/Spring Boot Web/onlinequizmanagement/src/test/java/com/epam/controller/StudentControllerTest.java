package com.epam.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.entity.Quiz;
import com.epam.service.StudentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

	@MockBean
	StudentService studentService;
		
	@Autowired
	private MockMvc mockMvc;
		
	private Quiz quiz;

	@BeforeEach
	void setUp() throws Exception {
		quiz = Quiz.builder()
				.quizTitle("Maths Quiz")
				.build();
	}
	
	@Test
	void showQuizTest() throws Exception {
		
		when(studentService.getQuizById(1)).thenReturn(quiz);
		mockMvc.perform(get("/student/showquiz?quizid=1"))
		.andExpect(status().isOk())
		.andExpect(view().name("quizviewstudent"));
		
	}
	
	@Test
	void getAllQuizTest() throws Exception {
		
		List<Quiz> quizList = List.of(quiz);
		
		when(studentService.getAllQuiz()).thenReturn(quizList);
		mockMvc.perform(get("/student/getquizes"))
		.andExpect(status().isOk()).andExpect(view().name("studentpage"));
		
	}
	
	
}
