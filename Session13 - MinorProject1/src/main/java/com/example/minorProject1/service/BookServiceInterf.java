package com.example.minorProject1.service;

import com.example.minorProject1.models.Book;
import com.example.minorProject1.requestDto.BookCreateRequest;

public interface BookServiceInterf {
	
	Book create(BookCreateRequest bookCreateRequest);

}
