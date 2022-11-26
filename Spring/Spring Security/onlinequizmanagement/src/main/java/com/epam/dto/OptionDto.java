package com.epam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionDto {
	
	private int id;
	
	private String optionName;
	
	private boolean isCorrect;
	
	private int questionId;
}
