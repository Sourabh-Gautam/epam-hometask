package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/customlogin")
	public String customLogin() {
		return "login";
	}
	
}
