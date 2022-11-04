package com.epam;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeedetails");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setName("sourabh");
		employee.setSalary(3234L);
		employee.setDepartment("development");
		
		AssetMgnt assetMgnt = new AssetMgnt();
		assetMgnt.setAssetName("One Plus");
		assetMgnt.setEmpId(employee.getEmpId());
		assetMgnt.setVendor("Firoj");
		
		employee.setAssetMgnt(List.of(assetMgnt));
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
