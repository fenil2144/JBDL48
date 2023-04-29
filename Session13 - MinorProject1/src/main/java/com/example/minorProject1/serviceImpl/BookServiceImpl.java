package com.example.minorProject1.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minorProject1.models.Author;
import com.example.minorProject1.models.Book;
import com.example.minorProject1.repository.BookRepositoryInterf;
import com.example.minorProject1.requestDto.BookCreateRequest;
import com.example.minorProject1.service.AuthorServiceInterf;
import com.example.minorProject1.service.BookServiceInterf;

@Service
public class BookServiceImpl implements BookServiceInterf {
	
	@Autowired
	BookRepositoryInterf bookRepositoryInterf;
	
	@Autowired
	AuthorServiceInterf authorServiceInterf;

	@Override
	public Book create(BookCreateRequest bookCreateRequest) {
		//Logic to check if Book is already existing in database
		Book book = bookCreateRequest.toBook();
		
		Author author = book.getAuthor();
		
		//Logic to check if Author already exist in database
		Author authorFromDb = authorServiceInterf.findByEmail(author.getEmail());
		System.out.println("After AUthor");
		System.out.println(authorFromDb.getBookList());
		if(authorFromDb == null) {
			authorFromDb = authorServiceInterf.createAuthor(author);
		}
		//this author object will have id
		book.setAuthor(authorFromDb);
		return bookRepositoryInterf.save(book);
	}

}
