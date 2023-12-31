package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.entity.Quiz;
import com.epam.entity.User;
import com.epam.service.StudentService;
import com.epam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	UserService userService;
	StudentService service;

	public UserController(UserService userService, StudentService service) {
		super();
		this.userService = userService;
		this.service = service;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = User.builder().username(username).password(password).role("student").build();
		userService.register(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("regsuccess");
		return mv;

	}

	@GetMapping("/login")
	public ModelAndView loginUser(HttpServletRequest request) {
		System.out.println("hi");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.getUserByUsername(username);
		ModelAndView mv = new ModelAndView();
		String view = "loginpage";
		if (user != null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			if (user.getRole().equals("admin")) {
				view = "adminpage";
			} else {
				List<Quiz> quizList = service.getAllQuiz();
				request.setAttribute("quizList", quizList);
				view = "studentpage";
			}
		}
		mv.setViewName(view);
		return mv;

	}

	@GetMapping("/registerpage")
	public ModelAndView registerPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registerpage");
		return mv;
	}

	@GetMapping("/loginpage")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginpage");
		return mv;
	}

}
