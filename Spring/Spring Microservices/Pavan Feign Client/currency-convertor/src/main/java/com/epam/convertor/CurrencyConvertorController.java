package com.epam.convertor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConvertorController {
	
	@Value("${exchange.url}")
	String exchangeUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ExchangeClient exchangeClient;
	

	@GetMapping("convertor/from/{from}/to/{to}/{quantity}")
	public ConvertorBean calculateCurrencyExchange(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
		exchangeUrl = exchangeUrl.concat("/from/").concat(from).concat("/to/").concat(to);
		System.out.println(exchangeUrl);
		ResponseEntity<ConvertorBean> convertorRes = restTemplate.exchange(exchangeUrl, HttpMethod.GET, null, ConvertorBean.class);
		ConvertorBean convertor = convertorRes.getBody();
		convertor.setQuantity(quantity);
		convertor.setAmount(convertor.getConversionValue().multiply(BigDecimal.valueOf(quantity)));
		System.out.println(convertor);
		return convertor;
	}
	
	@GetMapping("convertorf/from/{from}/to/{to}/{quantity}")
	public ConvertorBean calculateCurrencyExchangeUsingFeign(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
//		exchangeUrl = exchangeUrl.concat("/from/").concat(from).concat("/to/").concat(to);
//		System.out.println(exchangeUrl);
//		ResponseEntity<ConvertorBean> convertorRes = restTemplate.exchange(exchangeUrl, HttpMethod.GET, null, ConvertorBean.class);
		ResponseEntity<ConvertorBean> convertorRes = exchangeClient.getConversionValue(from, to);
		ConvertorBean convertor = convertorRes.getBody();
		convertor.setQuantity(quantity);
		convertor.setAmount(convertor.getConversionValue().multiply(BigDecimal.valueOf(quantity)));
		System.out.println(convertor+" using Feign");
		return convertor;
	}
	
	
}
