package com.ajscrawler.impl;

import com.ajscrawler.bean.response.CrawlListResponse;
import com.ajscrawler.bean.response.CrawlResponse;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CrawlerImpl {

    public CrawlerImpl() {
    }

    public CrawlerImpl(String URL) {
        urlToVisit.push(URL);
        this.OriginalUrl = URL;
    }

    // Max failed attempts
    private String OriginalUrl;
    private final int INDEX_LIMIT = 10;
    private final Stack<String> urlToVisit = new Stack<>();
    List<CrawlResponse> visitedUrl = new ArrayList<>();

    public CrawlListResponse crawl() {

        // Counter to keep track of number of indexed URLS
        CrawlListResponse crawlListResponse = new CrawlListResponse();
        int counter = 0;

        while (!urlToVisit.empty() && counter < INDEX_LIMIT) {

            String currentUrl = urlToVisit.pop();

            try {
                // Fetch and parse HTML document
                Document doc = Jsoup.connect(currentUrl)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36")
                        .referrer("http://www.google.com")
                        .timeout(12000)
                        .followRedirects(true)
                        .get();
                counter++;
                Elements links = doc.select("a[href]"); // Relative URL
                return addLinksToStack(links);

            } catch (IOException e) {
                e.getStackTrace();
                System.out.println("Error: " + currentUrl);
            }

        }
        return crawlListResponse;
    }

    public CrawlListResponse addLinksToStack(Elements el) {
        // For each element in links
        CrawlListResponse crawlListResponse = new CrawlListResponse();
        for (Element e : el) {
            String retrievedUrls = e.attr("abs:href");

            if (retrievedUrls.startsWith("http") && !oldLink(new CrawlResponse(retrievedUrls))) {
                urlToVisit.push(retrievedUrls);

                // Check  if same with primary URL
                if (retrievedUrls.toLowerCase().contains(OriginalUrl.toLowerCase())) {
                    visitedUrl.add(new CrawlResponse(retrievedUrls));
                    System.out.println(retrievedUrls);
                }
            }
        }
        crawlListResponse.setLstCrawlResponse(visitedUrl);
        crawlListResponse.setReturnCode(0); // Success
        return crawlListResponse;
    }

    public boolean oldLink(CrawlResponse link) {
        for (CrawlResponse s : visitedUrl) {
            if (s.getUrls().equals(link.getUrls())) {
                return true;
            }
        }
        return false;
    }
}
