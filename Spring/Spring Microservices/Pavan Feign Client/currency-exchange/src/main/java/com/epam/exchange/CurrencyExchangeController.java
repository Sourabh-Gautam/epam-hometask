package com.epam.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	ExchangeValueService service;
	
	@GetMapping("exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) throws Exception {
		return service.getValueByFromAndTo(from, to);
	}
}
