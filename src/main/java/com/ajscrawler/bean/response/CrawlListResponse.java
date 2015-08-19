/*
 * To change this license header, choose License Headers in Badge Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajscrawler.bean.response;
import java.util.List;

/**
 *
 * @author Mikael Gulapa
 */
public class CrawlListResponse {

    private List<CrawlResponse> lstCrawlResponse;
    private int returnCode;

    public CrawlListResponse() {
    }

    public CrawlListResponse(int returnCode) {
        this.returnCode = returnCode;
    }

    public CrawlListResponse(List<CrawlResponse> lstCrawlResponse, int returnCode) {
        this.lstCrawlResponse = lstCrawlResponse;
        this.returnCode = returnCode;
    }

    public List<CrawlResponse> getLstCrawlResponse() {
        return lstCrawlResponse;
    }

    public void setLstCrawlResponse(List<CrawlResponse> lstCrawlResponse) {
        this.lstCrawlResponse = lstCrawlResponse;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

 
}
