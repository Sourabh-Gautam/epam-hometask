package com.epam.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.epam.dto.OptionDto;
import com.epam.dto.QuestionDto;
import com.epam.dto.QuizDto;
import com.epam.entity.Option;
import com.epam.entity.Question;
import com.epam.entity.Quiz;
import com.epam.service.QuestionService;
import com.epam.service.QuizService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminController.class)
class AdminControllerTest {

	@MockBean
	QuizService quizService;

	@MockBean
	QuestionService questionService;

	@MockBean
	ModelMapper modelMapper;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void createQuizTest() throws Exception {

		QuizDto quizDto = QuizDto.builder().quizTitle("Solar System Quiz").build();

		Quiz quiz = Quiz.builder().quizTitle("Solar System Quiz").build();

		when(quizService.createQuiz(quiz)).thenReturn(quiz);

		String uri = "/admin/createquiz";
		String json = mapToJson(quizDto);

		MvcResult mvcResult = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonOutput).isNotNull().isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}

	@Test
	void showQuizByIdTest() throws Exception {

		Quiz quiz = Quiz.builder().id(1).quizTitle("Solar System Quiz").build();

		when(quizService.getQuizById(1)).thenReturn(Optional.ofNullable(quiz));

		String uri = "/admin/showquiz/1";

		MvcResult mvcResult = mockMvc.perform(get(uri)).andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonOutput).isNotNull().isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void showAllQuizTest() throws Exception {

		Quiz quiz = Quiz.builder().id(1).quizTitle("Solar System Quiz").build();

		when(quizService.getAllQuiz()).thenReturn(List.of(quiz));

		String uri = "/admin/showquiz";

		MvcResult mvcResult = mockMvc.perform(get(uri)).andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonOutput).isNotNull().isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void deleteQuizByIdTest() throws Exception {

		Quiz quiz = Quiz.builder().id(1).quizTitle("Solar System Quiz").build();

		when(quizService.getQuizById(1)).thenReturn(Optional.ofNullable(quiz));
		when(quizService.deleteQuizById(1)).thenReturn(1);

		String uri = "/admin/deletequiz/1";

		MvcResult mvcResult = mockMvc.perform(delete(uri)).andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonOutput).isNotNull().isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void renameQuizTest() throws Exception {

		QuizDto quizDto = QuizDto.builder().id(1).quizTitle("Solar System Quiz").build();
		Quiz quiz = Quiz.builder().id(1).quizTitle("Solar System Quiz").build();
		Quiz renamedQuiz = Quiz.builder().id(1).quizTitle("Universe Quiz").build();

		when(quizService.getQuizById(1)).thenReturn(Optional.ofNullable(quiz));
		when(quizService.renameQuiz(quiz)).thenReturn(renamedQuiz);
		
		String json = mapToJson(quizDto);

		String uri = "/admin/renamequiz";

		MvcResult mvcResult = mockMvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(mapToDto(jsonOutput).getQuizTitle()).isEqualTo("Universe Quiz");
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void deleteQuestionTest() throws Exception {

		Question question = Question.builder().id(1).questionStatement("What is moon?").build();
		QuestionDto questionDto = QuestionDto.builder().id(1).questionStatement("What is moon?").build();
		
		when(questionService.findQuestionById(1)).thenReturn(Optional.ofNullable(question));
		when(questionService.deleteQuestionById(1)).thenReturn(1);
		
		String json = mapToJson(questionDto);

		String uri = "/admin/deletequestion/1";

		MvcResult mvcResult = mockMvc.perform(delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonOutput).isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void addQuestionTest() throws Exception {

		List<Option> optionList = List.of(Option.builder().optionName("Satellite").isCorrect(true).build());
		List<OptionDto> optionDtoList = List.of(OptionDto.builder().optionName("Satellite").isCorrect(true).build());
		
		Question question = Question.builder().questionStatement("What is moon?").optionList(optionList).build();
		QuestionDto questionDto = QuestionDto.builder().questionStatement("What is moon?").optionList(optionDtoList).build();
		
		when(questionService.addQuestion(question)).thenReturn(question);
		
		String json = mapToJson(questionDto);
		
		String uri = "/admin/addquestion";

		MvcResult mvcResult = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonOutput).isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}

	String mapToJson(QuizDto quizDto) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(quizDto);
		return json;
	}
	
	QuizDto mapToDto(String quizJson) throws JsonProcessingException {
		ObjectMapper ow = new ObjectMapper();
		QuizDto quizDto = ow.readValue(quizJson, QuizDto.class);
		return quizDto;
	}
	

	private String mapToJson(QuestionDto questionDto) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(questionDto);
		return json;
	}

}
