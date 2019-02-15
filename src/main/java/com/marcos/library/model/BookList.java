package com.marcos.library.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookList {
	private int numberBooks = 0;
	private List<Book> books = new ArrayList<Book>();
	
	public BookList() {
		
	}
	
	public BookList(List<Book> books) {
		if(books != null) {
			this.books = books;
			this.numberBooks = books.size();			
		}
	}
}
