package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.entity.User;

@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model model) {
		model.addAttribute("loginData", new User());
		return "form";
	}
	
}
