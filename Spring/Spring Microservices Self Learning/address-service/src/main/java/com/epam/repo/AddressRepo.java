package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epam.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	@Query(nativeQuery = true, value = "SELECT ea.id, ea.lane1, ea.lane2, ea.state, ea.zip FROM employeeservicese.address ea join employeeservicese.employee e on e.id = ea.employee_id where ea.employee_id = :employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
	
}
