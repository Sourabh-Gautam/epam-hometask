package com.epam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepo extends JpaRepository<Book, Integer>{

	// Query Method Approach 
	public List<Book> findByName(String bookName); 
	
	public List<Book> findByPriceOrNoOfBooksInStock(double price,int noOfBooksInStock); 
	
	@Query("select b from Book b where b.price=?1")
	public List<Book> getBooksPriceGreaterThan(double amount); 
	
	
	@Modifying
	@Query("update Book b set b.price =?1 where b.name=?2")
	public List<Book> updateBooks(double amount,String bookName);
}
