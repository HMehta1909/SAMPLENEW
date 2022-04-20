package com.capg.SpringDemo4.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.SpringDemo4.Model.Book;
import com.capg.SpringDemo4.Service.BookService;
import com.capg.SpringDemo4.Exception.ResourceNotFoundException;

@RestController
@RequestMapping("Book")
public class BookRestController {
	@Autowired
	BookService bookService;

	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@Validated @RequestBody Book book) {
		Book bookResponse = bookService.addBook(book);
		return new ResponseEntity<String>(bookResponse.toString(), HttpStatus.OK);
	}

	@GetMapping("/getAllBook")
	public ResponseEntity<List<Book>> getAllBook() {
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}

	@GetMapping("/fetchBookById")
	public ResponseEntity<Book> fetchBookById(@RequestParam("id") int id) {
		Optional<Book> book = bookService.fetchBookById(id);
		return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
	}
	
	@PutMapping("/updateByBookId")
	public ResponseEntity<String> updateByBookId(@RequestBody Book book){
		Optional<Book> b = bookService.fetchBookById(book.getBookId());
		if(b.isPresent()) {
			bookService.updateBookById(book);
		}
		else {
			throw new ResourceNotFoundException ("ID NOT AVAILABLE!!!");
		}
		return new ResponseEntity<String>("UPDATED", HttpStatus.BAD_REQUEST );
	}
}
