package com.example.SpringBootDemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.model.Book;

@RestController
public class BookController {
	
	private static Logger logger = LoggerFactory.getLogger(BookController.class);
	
	private HashMap<Integer, Book> bookHashMap = new HashMap<Integer, Book>();
	
	// insertBook - Post - RequestBody
	// updateBook - Put - RequestBody
	// GetBookDetails - Get - Path Variable - bookId
	// deleteBook - Delete - Path Variable - bookId
	// getAllBooks - Get
	
	@PostMapping("/book")
	public String insertBook(@RequestBody Book book) {
		logger.info(book.toString());
		if(bookHashMap.containsKey(book.getId())) {
			logger.error("Book With this ID Already Exist!");
			return "Book With this ID Already Exist!";
		}
		bookHashMap.put(book.getId(), book);
		return "Book Inserted Successfully";
	}
	
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book book) {
		bookHashMap.put(book.getId(), book);
		return bookHashMap.get(book.getId());
	}
	
	@GetMapping("/book/{bookId}")
	public Book getBookDetails(@PathVariable("bookId") int bookId) {
		logger.info(Integer.toString(bookId));
		return bookHashMap.get(bookId);
	}
	
	@DeleteMapping("/book/{bookId}")
	public String deleteBook(@PathVariable("bookId") int bookId) {
		bookHashMap.remove(bookId);
		return "Book Deleted Successfully";
	}
	
	@GetMapping("/book")
	public List<Book> getBooks(){
		return bookHashMap.values().stream().collect(Collectors.toList());
	}

}
