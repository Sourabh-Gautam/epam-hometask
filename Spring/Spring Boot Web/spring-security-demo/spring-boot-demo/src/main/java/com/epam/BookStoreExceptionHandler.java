package com.epam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class BookStoreExceptionHandler {

	@ExceptionHandler(value = { BookNotFoundException.class, IOException.class })
	public ModelAndView handlerForBookNotFoundException(HttpServletRequest request, BookNotFoundException be) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("exception", be);
		mv.addObject("url", request.getRequestURL());
		mv.setViewName("error");

		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerForException(HttpServletRequest request, Exception e) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("exception", e);
		mv.addObject("exception-stacktrace", e.getStackTrace());
		mv.addObject("url", request.getRequestURL());
		mv.setViewName("error");


		return mv;
	}

}
