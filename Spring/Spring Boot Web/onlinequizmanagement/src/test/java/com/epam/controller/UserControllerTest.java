package com.epam.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.entity.User;
import com.epam.service.StudentService;
import com.epam.service.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
	
	@MockBean
	UserService userService;
	
	@MockBean
	StudentService service;
	
		
	@Autowired
	private MockMvc mockMvc;
		
	private User user;

	@BeforeEach
	void setUp() throws Exception {
		user = User.builder()
			.username("epam")
			.password("epam")
			.role("student")
			.build();
	}

	@Test
	void registerUserTest() throws Exception {
		
		User myUser = User.builder()
				.username("epam")
				.password("epam")
				.role("student")
				.build();

		when(userService.register(myUser)).thenReturn(user);
		mockMvc.perform(post("/user/register?username=epam&password=epam"))
		.andExpect(status().isOk())
		.andExpect(view().name("regsuccess"));
		
	}
	
	@Test
	void loginUserAdminTest() throws Exception {
		
		User myUser = User.builder()
				.username("epam")
				.password("epam")
				.role("admin")
				.build();
		
		when(userService.getUserByUsername("epam")).thenReturn(myUser);
		mockMvc.perform(get("/user/login?username=epam&password=epam"))
		.andExpect(status().isOk())
		.andExpect(view().name("adminpage"));
		
	}
	
	@Test
	void registerPageViewReturnTest() throws Exception {
		
		mockMvc.perform(get("/user/registerpage"))
		.andExpect(status().isOk());
		
	}
	
	@Test
	void loginPageViewReturnTest() throws Exception {
		
		mockMvc.perform(get("/user/loginpage"))
		.andExpect(status().isOk());
		
	}
}
