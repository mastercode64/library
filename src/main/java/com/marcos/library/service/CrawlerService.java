package com.marcos.library.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CrawlerService {
	
	@Value("${crawler.url}")
	private String crawlerUrl;

	public void getPageHtml() throws Exception {
		
		Document doc = Jsoup.connect(crawlerUrl).get();
		Elements bookList = doc.select("article.page-content");
		
		
	}
}
