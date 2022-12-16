package com.epam.convertor;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ConvertorBean {

	int id;
	String from;
	String to;
	int quantity;
	BigDecimal conversionValue;
	BigDecimal amount;
}
