/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ajscrawler.bean.request;

/**
 *
 * @author Mikael Gulapa
 */
public class CrawlRequest {

    public CrawlRequest() {
    }
    
    private String urlToCrawl;

    public String getUrlToCrawl() {
        return urlToCrawl;
    }

    public void setUrlToCrawl(String urlToCrawl) {
        this.urlToCrawl = urlToCrawl;
    }

}
