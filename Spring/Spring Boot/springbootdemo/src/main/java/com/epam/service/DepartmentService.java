package com.epam.service;

import java.util.List;

import com.epam.entity.Department;
import com.epam.exception.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long departmentId);

	Department updateDepartment(Long departmentId, Department department);

	Department fetchDepartmentByName(String departmentName);

	Department fetchDepartmentByCode(String departmentName);

}
