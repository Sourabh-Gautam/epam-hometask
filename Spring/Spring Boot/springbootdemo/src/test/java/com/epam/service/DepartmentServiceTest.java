package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.entity.Department;
import com.epam.exception.DepartmentNotFoundException;
import com.epam.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder()
				.departmentName("IT")
				.departmentAddress("Udaypur")
				.departmentCode("A-105")
				.build();
		when(departmentRepository.findById(1L)).thenReturn(Optional.ofNullable(department));
	}

	@Test
	@DisplayName("When id found department should return")
	void fetchDepartmentByIdTest() {
		Long departmentId = 1L;
		Department department = null;
		try {
			department = departmentService.fetchDepartmentById(departmentId);
		} catch (DepartmentNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("IT", department.getDepartmentName());
	}
	
	

}
