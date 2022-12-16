package com.epam.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.OptionDto;
import com.epam.dto.QuestionDto;
import com.epam.dto.QuizDto;
import com.epam.entity.Option;
import com.epam.entity.Question;
import com.epam.entity.Quiz;
import com.epam.exception.EmptyFieldException;
import com.epam.exception.ResourceNotFoundException;
import com.epam.service.QuestionService;
import com.epam.service.QuizService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionService questionService;

//	Quiz Section

	@PostMapping("/createquiz")
	public ResponseEntity<QuizDto> createQuiz(@RequestBody QuizDto quizDto)
			throws EmptyFieldException, NoSuchFieldException {

		if (quizDto.getQuizTitle() == null) {
			throw new NoSuchFieldException("Field cannot be null. Make sure every key is provided with correct name");
		}
		if (quizDto.getQuizTitle().isBlank()) {
			throw new EmptyFieldException("Quiz title cannot be empty");
		}

		ModelMapper modelMapper = new ModelMapper();
		Quiz quiz = modelMapper.map(quizDto, Quiz.class);
		Quiz quizdb = quizService.createQuiz(quiz);

		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(quizdb, QuizDto.class));

	}

	@GetMapping("/showquiz/{quizid}")
	public ResponseEntity<QuizDto> showQuiz(@PathVariable(name = "quizid") int quizId)
			throws ResourceNotFoundException {
		System.out.println(quizId);
		ModelMapper modelMapper = new ModelMapper();
		Quiz quiz = quizService.getQuizById(quizId)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + quizId));

		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(quiz, QuizDto.class));

	}

	@GetMapping("/showquiz")
	public ResponseEntity<List<QuizDto>> showAllQuiz() {

		ModelMapper modelMapper = new ModelMapper();
		List<Quiz> quizList = quizService.getAllQuiz();
		List<QuizDto> quizDtoList = new ArrayList<>();

		for (Quiz quiz : quizList) {
			quizDtoList.add(modelMapper.map(quiz, QuizDto.class));
		}

		return ResponseEntity.status(HttpStatus.OK).body(quizDtoList);

	}

	@DeleteMapping("/deletequiz/{quizid}")
	public ResponseEntity<QuizDto> deleteQuiz(@PathVariable(name = "quizid") int quizId)
			throws ResourceNotFoundException {

		ModelMapper modelMapper = new ModelMapper();
		Quiz quiz = quizService.getQuizById(quizId)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + quizId));
		quizService.deleteQuizById(quizId);

		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(quiz, QuizDto.class));

	}

	@PutMapping("/renamequiz")
	public ResponseEntity<Object> renameQuiz(@RequestBody QuizDto quizDto) throws ResourceNotFoundException {
		ModelMapper modelMapper = new ModelMapper();
		Quiz quiz = quizService.getQuizById(quizDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + quizDto.getId()));
		quiz.setQuizTitle(quizDto.getQuizTitle());
		Quiz updatedQuiz = quizService.renameQuiz(quiz);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(updatedQuiz, QuizDto.class));

	}

//	Question Section

	@DeleteMapping("/deletequestion/{questionid}")
	public ResponseEntity<QuestionDto> deleteQuestion(@PathVariable(name = "questionid") int questionId)
			throws ResourceNotFoundException {

		ModelMapper modelMapper = new ModelMapper();
		Question question = questionService.findQuestionById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found with the id " + questionId));
		questionService.deleteQuestionById(questionId);

		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(question, QuestionDto.class));

	}

	@PostMapping("/addquestion")
	public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto questionDto)
			throws EmptyFieldException, NoSuchFieldException {

		ModelMapper modelMapper = new ModelMapper();
		if (questionDto.getQuestionStatement() == null) {
			throw new NoSuchFieldException("Field cannot be null. Make sure every key is provided with correct name");
		}

		if (questionDto.getQuestionStatement().isBlank()) {
			throw new EmptyFieldException("Question statement cannot be empty");
		}

		List<Option> optionList = new ArrayList<>();

		for (OptionDto optionDto : questionDto.getOptionList()) {
			optionList.add(modelMapper.map(optionDto, Option.class));
		}

		Question question = Question.builder().questionStatement(questionDto.getQuestionStatement())
				.optionList(optionList).quizId(questionDto.getQuizId()).build();

		Question dbQuesiton = questionService.addQuestion(question);

		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(dbQuesiton, QuestionDto.class));

	}

}
