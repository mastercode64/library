package com.marcos.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.library.dao.BookDao;
import com.marcos.library.model.Book;
import com.marcos.library.service.CrawlerService;

@RestController
@RequestMapping(path = "/books")
public class BookController {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private CrawlerService crawlerService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks() throws Exception {
//		List<Book> books = bookDao.findAll();
//		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		crawlerService.getPageHtml();
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Book> createCustomer(@RequestBody Book book) {
		bookDao.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
		Book book = bookDao.findById(id).orElse(null);
		if(book == null)
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

}
