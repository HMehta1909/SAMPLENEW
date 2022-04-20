package com.capg.SpringDemo4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.SpringDemo4.Model.Book;
import com.capg.SpringDemo4.Repository.IBookRepo;

@Service
public class BookService {
	
	@Autowired
	IBookRepo bookrepo;
	
	public Book addBook(Book bookObj) {
		
		return bookrepo.save(bookObj);
	}

	public List<Book> getAllBooks() {
		return bookrepo.findAll();
	}

	public Optional<Book> fetchBookById(int id) {
		// TODO Auto-generated method stub
		return bookrepo.findById(id);
		
	}

	public void updateBookById(Book book) {
		// TODO Auto-generated method stub
		if(bookrepo.existsById(book.getBookId())) {
			bookrepo.save(book);
		}
	}

}
