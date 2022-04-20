package com.capg.SpringDemo4.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capg.SpringDemo4.Model.Book;
import com.capg.SpringDemo4.Service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService ;

	@RequestMapping("/home")
	public void home() {
		System.out.println("HOME EXECUTED");
		
	}
	
	@RequestMapping("/addBook")
	@ResponseBody
	public Book addBook(Book book) {
		Book bookResponse = bookService.addBook(book);
		return bookResponse;
	}
	
	@RequestMapping("/getAllBook")
	@ResponseBody
	public List<Book> getAllBook(Book book) {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/fetchBookById")
	public ModelAndView fetchBookById(@RequestParam("id") int id) {
		Optional<Book> book = bookService.fetchBookById(id);
		
		ModelAndView mv = new ModelAndView();
		if(book.isPresent()) {
			mv.addObject("book", book.get());
			mv.setViewName("Book");
		}
		else {
			mv.addObject("book", "Not Available");
			mv.setViewName("Book");
		}
		System.out.println(mv);
		return mv;
	}
	
}
	