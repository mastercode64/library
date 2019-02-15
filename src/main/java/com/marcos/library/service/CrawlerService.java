package com.marcos.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.marcos.library.helper.WebcrawlerHelper;
import com.marcos.library.model.Book;
import com.marcos.library.model.BookList;



@Service
public class CrawlerService {
	
	@Value("${crawler.url}")
	private String crawlerUrl;
	
	private String cssQuery = "article.page-content.g-9";
	private Book book;

	public BookList getBooksFromUrl() throws Exception {
		
		System.out.println("Retrieving html from " + crawlerUrl);
		Elements elements = WebcrawlerHelper.getHtmlContent(crawlerUrl, cssQuery);
		
		List<Book> bookList = new ArrayList<Book>();
		book = new Book();
		
		int bookIndex = 0;
		for(Element element: elements) {
			//Get Title from <h2>
			if(book.getTitle() == null) {
				if(element.tagName().toLowerCase() == "h2")
					book.setTitle(element.text());
			}
			
			//Get Language from <div> with class book-lang
			else if(book.getLanguage() == null) {
				if(element.tagName().toLowerCase().equals("div") && element.className().toLowerCase().equals("book-lang"))
					book.setLanguage(element.text());
			}
			
			//Search from isbn from link
			else if(element.tagName().toLowerCase().equals("a") && element.child(0).className().toLowerCase().equals("book-cover-image")) {
				String isbnLink = element.attr("href");
				System.out.println("Searching for isbn..");
				Elements isbnHtml = WebcrawlerHelper.getHtmlContent(isbnLink, "body");
				String isbn = WebcrawlerHelper.findIsbnInElements(isbnHtml);
				book.setIsbn(isbn);
			}
			
			//Get Description from all subsequent <p> tags 
			else if(element.tagName().toLowerCase().equals("p")) {
				String description = Optional.ofNullable(book.getDescription()).orElse("") + element.text();
				book.setDescription(description);
				
				//End book information if current element is the last or next element is h2
				if(element.nextElementSibling() == null || element.nextElementSibling().tagName().toLowerCase().equals("h2")) {
					bookList.add(book);
					System.out.println("Finished book " + bookIndex + ": " + book.getTitle());
					book = new Book();
					bookIndex ++;
				}
			}
		}

		
		return new BookList(bookList);
	}
}
