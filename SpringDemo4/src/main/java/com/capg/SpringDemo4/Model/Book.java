package com.capg.SpringDemo4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Book {
	@Id
	private int bookId;

	@NotBlank
	@Size(min = 2, message = "MIN 2 char required.")
	private String name;

	//	@Email(message="Fomat wrong")
	private String authorName;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String name, String authorName) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.authorName = authorName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public int getBookId() {
		return bookId;
	}

	public String getName() {
		return name;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", authorName=" + authorName + "]";
	}

}
