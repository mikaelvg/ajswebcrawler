/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ajscrawler.bean.response;

/**
 *
 * @author Mikael Gulapa
 */
public class CrawlResponse {

    public CrawlResponse() {
    }

    public CrawlResponse(String urls) {
        this.urls = urls;
    }
    
    private String urls;

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
  
}
