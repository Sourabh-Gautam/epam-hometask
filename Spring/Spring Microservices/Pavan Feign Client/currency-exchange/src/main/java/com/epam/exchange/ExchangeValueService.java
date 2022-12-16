package com.epam.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueService {
	
	@Autowired
	ExchangeValueRepository repo;
	
	public ExchangeValue getValueByFromAndTo(String from, String to) throws Exception {
		System.out.println("from");
		return repo.findByFromAndTo(from, to).orElseThrow(() -> new Exception("Currency Exchange not Found for the combination"));
	}

}
