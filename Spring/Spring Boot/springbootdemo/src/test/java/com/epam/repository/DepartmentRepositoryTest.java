package com.epam.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.epam.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.departmentName("IT")
				.departmentAddress("Udaypur")
				.departmentCode("A-105")
				.build();
		entityManager.persist(department);
	}


	void fetchDepartmentByIdRepositoryTest() {
		Long departmentId = 1L;
		Department department = departmentRepository.findById(departmentId).get();
		assertEquals("IT", department.getDepartmentName());
	}
	
	

}
