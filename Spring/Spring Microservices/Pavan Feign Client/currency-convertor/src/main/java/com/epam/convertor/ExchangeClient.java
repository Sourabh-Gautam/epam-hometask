package com.epam.convertor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "currency-exchange",url = "http://localhost:8080/" )
public interface ExchangeClient {

	@GetMapping("exchange/from/{from}/to/{to}")
	public ResponseEntity<ConvertorBean> getConversionValue(@PathVariable String from,@PathVariable String to);
	
	@PutMapping("exchange/from/{from}/to/{to}")
	public ResponseEntity<ConvertorBean> getConversionValueUsingPut(@PathVariable String from,@PathVariable String to);
}
