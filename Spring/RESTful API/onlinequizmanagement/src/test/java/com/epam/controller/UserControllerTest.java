package com.epam.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.epam.dto.UserDto;
import com.epam.entity.User;
import com.epam.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

	@MockBean
	UserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void registerUserTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").password("epam").role("student").build();

		User myUser = User.builder().username("epam").password("epam").role("student").build();
		when(userService.register(myUser)).thenReturn(myUser);

		String uri = "/user/register";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		
		assertThat(jsonOutput).isNotNull().isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
	}
	
	@Test
	void registerUserWithNullUsernameTest() throws Exception {
		
		UserDto userDto = UserDto.builder().password("epam").role("student").build();
		
		String uri = "/user/register";
		String json = mapToJson(userDto);
		
		MvcResult mvcResult = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		
		assertThat(HttpStatus.BAD_REQUEST.value()).isEqualTo(mvcResult.getResponse().getStatus());
		
	}
	
	@Test
	void registerUserWithEmptyUsernameTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("").password("epam").role("student").build();
		
		String uri = "/user/register";
		String json = mapToJson(userDto);
		
		MvcResult mvcResult = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		
		assertThat(HttpStatus.BAD_REQUEST.value()).isEqualTo(mvcResult.getResponse().getStatus());
		
	}
	
	@Test
	void registerUserWithNullPasswordTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").role("student").build();
		
		String uri = "/user/register";
		String json = mapToJson(userDto);
		
		MvcResult mvcResult = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		
		assertThat(HttpStatus.BAD_REQUEST.value()).isEqualTo(mvcResult.getResponse().getStatus());
		
	}
	
	@Test
	void registerUserWithEmptyPasswordTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").password("").role("student").build();
		
		String uri = "/user/register";
		String json = mapToJson(userDto);
		
		MvcResult mvcResult = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		
		assertThat(HttpStatus.BAD_REQUEST.value()).isEqualTo(mvcResult.getResponse().getStatus());
		
	}

	@Test
	void loginUserTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").password("epam").role("admin").build();

		Optional<User> myUser = Optional.ofNullable(User.builder().username("epam").password("epam").role("admin").build());
		when(userService.getUserByUsername("epam")).thenReturn(myUser);

		String uri = "/user/login";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		
		assertThat(jsonOutput).isNotNull().isNotBlank();
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void loginUserWithNullUsernameTest() throws Exception {
		
		UserDto userDto = UserDto.builder().password("epam").role("admin").build();

		String uri = "/user/login";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void loginUserWithNullPasswordTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").role("admin").build();

		String uri = "/user/login";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void loginUserWithEmptyUsernameTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("").password("epam").role("admin").build();

		String uri = "/user/login";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void loginUserWithEmptyPasswordTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").password("").role("admin").build();

		String uri = "/user/login";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void loginUserButUserNotFoundTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").password("epam").role("admin").build();
		
		Optional<User> myUser = Optional.ofNullable(null);
		when(userService.getUserByUsername("epam")).thenReturn(myUser);

		String uri = "/user/login";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		assertEquals(HttpStatus.NOT_FOUND.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	void loginUserWithWrongCredentialsTest() throws Exception {
		
		UserDto userDto = UserDto.builder().username("epam").password("epam").role("admin").build();
		
		Optional<User> myUser = Optional.ofNullable(User.builder().username("epam").password("epam2").role("admin").build());
		when(userService.getUserByUsername("epam")).thenReturn(myUser);

		String uri = "/user/login";
		String json = mapToJson(userDto);

		MvcResult mvcResult = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		assertEquals(HttpStatus.EXPECTATION_FAILED.value(), mockHttpServletResponse.getStatus());

	}

	
	String mapToJson(UserDto userDto) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(userDto);
		return json;
	}
}