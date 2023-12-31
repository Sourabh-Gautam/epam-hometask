package com.epam.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.epam.entity.Option;
import com.epam.entity.Question;
import com.epam.entity.Quiz;
import com.epam.service.AdminService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminController.class)
class AdminControllerTest {

	@MockBean
	AdminService adminService;
		
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
	void createQuizTest() throws Exception {
		
		Quiz myquiz = Quiz.builder()
				.quizTitle("Maths Quiz")
				.build();

		when(adminService.createQuiz(myquiz)).thenReturn(quiz);
		mockMvc.perform(post("/admin/createquiz?quizname=Maths Quiz"))
		.andExpect(status().isOk())
		.andExpect(view().name("adminpage"));
		
	}
	
	@Test
	void unableToCreateQuizTest() throws Exception {

		when(adminService.createQuiz(quiz)).thenReturn(null);
		mockMvc.perform(post("/admin/createquiz?quizname=Maths Quiz"))
		.andExpect(status().isOk())
		.andExpect(view().name("createquizpage"));
		
	}
	
	@Test
	void showQuizTest() throws Exception {
		
		when(adminService.getQuizById(1)).thenReturn(quiz);
		mockMvc.perform(get("/admin/showquiz?quizid=1"))
		.andExpect(status().isOk())
		.andExpect(view().name("quizviewadmin"));
		
	}
	
	@Test
	void deleteQuizTest() throws Exception {
		
		when(adminService.deleteQuizById(1)).thenReturn(1);
		mockMvc.perform(post("/admin/deletequiz?quizid=1"))
		.andExpect(status().isOk())
		.andExpect(view().name("adminpage"));
		
	}
	
	@Test
	void deleteQuestionTest() throws Exception {
		
		when(adminService.deleteQuestionById(1)).thenReturn(1);
		when(adminService.getQuizById(1)).thenReturn(quiz);
		mockMvc.perform(post("/admin/deletequestion?quizid=1&questionid=1"))
		.andExpect(status().isOk())
		.andExpect(view().name("quizviewadmin"));
		
	}
	
	@Test
	void addQuestionTest() throws Exception {
		
		Quiz mockQuiz = mock(Quiz.class);
		
		List<Option> optionList = List.of(
				Option.builder().optionName("book").isCorrect(false).questionId(1).build(),
				Option.builder().optionName("subject").isCorrect(true).questionId(1).build(),
				Option.builder().optionName("course").isCorrect(false).questionId(1).build(),
				Option.builder().optionName("training").isCorrect(false).questionId(1).build()
				);
		
		Question question = Question.builder()
				.questionStatement("What is math")
				.optionList(optionList)
				.build();
		
		when(adminService.addQuestion(question)).thenReturn(question);
		when(adminService.getQuizById(1)).thenReturn(mockQuiz);
		String queryString = "/admin/addquestion?questionstatement=what+is+math&option1=book&option2=subject&option3=course&option4=training&correctoption=2&quizid=1";
		mockMvc.perform(post(queryString))
		.andExpect(status().isOk())
		.andExpect(view().name("quizviewadmin"));
		
	}
	
	@Test
	void saveQuizTest() throws Exception {

		mockMvc.perform(get("/admin/createquizpage"))
		.andExpect(status().isOk())
		.andExpect(view().name("createquizpage"));
		
	}
	
	@Test
	void getAllQuizTest() throws Exception {
		
		List<Quiz> quizList = List.of(quiz);
		
		when(adminService.getAllQuiz()).thenReturn(quizList);
		mockMvc.perform(get("/admin/operatequizpage"))
		.andExpect(status().isOk()).andExpect(view().name("operatequizpage"));
		
	}
	
	
}
