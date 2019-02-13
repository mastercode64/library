package com.marcos.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.library.dao.BookDao;
import com.marcos.library.model.Book;

@RestController
@RequestMapping(path = "/")
public class BookController {
	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/books")
	public List getBooks() {
		return bookDao.findAll();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity getBook(@PathVariable("id") Long id) {
		Book book = bookDao.findById(id).orElse(null);
		if(book == null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

}
