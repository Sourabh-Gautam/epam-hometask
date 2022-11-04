package com.epam.onetoonerelationship;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Product product = new Product();
		product.setProductName("Vatika");
		
		Product product2 = new Product();
		product2.setProductName("Clinic Plus");
		
		Collection<Product> productCollection = new ArrayList<Product>();
		productCollection.add(product);
		productCollection.add(product2);
		
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("Shampoo");
		productCategory.setProductCollection(productCollection);
		
		Collection<ProductCategory> productCategoryCollection = new ArrayList<ProductCategory>();
		productCategoryCollection.add(productCategory);
		
		Shop shop = new Shop();
		shop.setShopName("General Store");
		shop.setProductCategoryCollection(productCategoryCollection);
		
		entityManager.getTransaction().begin();
		entityManager.persist(shop);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
