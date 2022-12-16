package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
