package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chatperId;
	
	private String chapterTitle;
	
	@ManyToOne
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getChatperId() {
		return chatperId;
	}

	public void setChatperId(int chatperId) {
		this.chatperId = chatperId;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	@Override
	public String toString() {
		return "Chapter [chatperId=" + chatperId + ", chapterTitle=" + chapterTitle +" ]";
	}
	
	
	
}
