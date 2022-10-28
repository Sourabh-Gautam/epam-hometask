package com.epam;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
