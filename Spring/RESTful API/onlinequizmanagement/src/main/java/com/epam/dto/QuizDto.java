package com.epam.dto;

import java.util.List;

import com.epam.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizDto {
	
	private int id;
	
	private String quizTitle;

	private List<Question> questionList;

}
