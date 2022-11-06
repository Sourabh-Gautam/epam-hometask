package com.epam.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.epam.entity.Department;
import com.epam.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = Department.builder()
				.departmentId(1L)
				.departmentName("IT")
				.departmentAddress("Udaypur")
				.departmentCode("A-105")
				.build();
	}

	@Test
	void saveControllerTest() throws Exception {
		Department departmentSave = Department.builder()
				.departmentName("IT")
				.departmentAddress("Banglore")
				.departmentCode("105-B")
				.build();
		when(departmentService.saveDepartment(departmentSave)).thenReturn(department);
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "	\"departmentName\" : \"IT\",\r\n"
						+ "	\"departmentAddress\" : \"Banglore\",\r\n"
						+ "	\"departmentCode\" : \"105-B\"\r\n"
						+ "}"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
