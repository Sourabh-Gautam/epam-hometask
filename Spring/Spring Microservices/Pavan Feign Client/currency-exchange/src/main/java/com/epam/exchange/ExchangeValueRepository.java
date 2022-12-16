package com.epam.exchange;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Integer>{
	
	Optional<ExchangeValue> findByFromAndTo(String from, String to);

}
