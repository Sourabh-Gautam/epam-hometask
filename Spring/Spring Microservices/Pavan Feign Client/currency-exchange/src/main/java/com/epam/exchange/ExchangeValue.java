package com.epam.exchange;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

	@Id
	int id;
	@Column(name = "currency_from")
	String from;
	@Column(name = "currency_to")
	String to;
	@Column(name = "conversion_value")
	BigDecimal conversionValue;
}
