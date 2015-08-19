package com.ajscrawler.facade;

import com.ajscrawler.impl.CrawlerImpl;


public class CrawlTester {
	
	public static void main(String args[]) {
		
		CrawlerImpl crawlerImpl = new CrawlerImpl("http://wiprodigital.com");
		crawlerImpl.crawl();	
	}
	
}
