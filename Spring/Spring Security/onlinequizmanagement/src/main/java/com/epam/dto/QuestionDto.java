package com.epam.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {

	private int id;
	
	private String questionStatement;

	private List<OptionDto> optionList;
	
	private int quizId;
	
}
