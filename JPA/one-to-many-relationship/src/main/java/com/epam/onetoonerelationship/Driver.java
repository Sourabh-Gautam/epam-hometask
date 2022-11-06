package com.epam.onetoonerelationship;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Shop shop = new Shop();
		shop.setShopName("General Store");
		
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("Shampoo");
		System.out.println(shop.getShopId());
		productCategory.setShopId(shop.getShopId());
		
		Product product = new Product();
		product.setProductName("Vatika");
		product.setProductCategoryId(productCategory.getProductCategoryId());
		
		productCategory.setProductCollection(List.of(product));
		
		shop.setProductCategoryCollection(List.of(productCategory));
		
		entityManager.getTransaction().begin();
//		entityManager.persist(shop);
		entityManager.remove(entityManager.find(Shop.class, 1));
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
