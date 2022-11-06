package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epam.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	public Department findByDepartmentName(String departmentName);
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	
//	@Query("from Department dept where dept.departmentCode = ?1")
	@Query(value = "select * from department where department_code = ?1", nativeQuery = true)
	public Department getDepartmentUsingCode(String departmentName);
}
