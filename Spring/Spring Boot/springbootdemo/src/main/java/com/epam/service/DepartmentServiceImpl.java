package com.epam.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Department;
import com.epam.exception.DepartmentNotFoundException;
import com.epam.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
		if(!departmentOptional.isPresent()) {
			throw new DepartmentNotFoundException("Department not available");
		}
		return departmentOptional.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		
		Department dbDepartment = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().equals("")) {
			dbDepartment.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().equals("")) {
			dbDepartment.setDepartmentCode(department.getDepartmentCode());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().equals("")) {
			dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		departmentRepository.save(dbDepartment);
		
		return dbDepartment;
		
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

	@Override
	public Department fetchDepartmentByCode(String departmentName) {
		return departmentRepository.getDepartmentUsingCode(departmentName);
	}

}
