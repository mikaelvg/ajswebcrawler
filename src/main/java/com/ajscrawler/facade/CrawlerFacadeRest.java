/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajscrawler.facade;

import com.ajscrawler.bean.request.CrawlRequest;
import com.ajscrawler.bean.response.CrawlListResponse;
import com.ajscrawler.impl.CrawlerImpl;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Mikael Gulapa
 */

@Stateless
@Path("rest.crawl")
public class CrawlerFacadeRest {

    public CrawlerFacadeRest() {
    }
    
    
    
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public CrawlListResponse crawlSite(CrawlRequest crawlRequest) {
        CrawlerImpl crawlerImpl = new CrawlerImpl(crawlRequest.getUrlToCrawl());
        return crawlerImpl.crawl();
    }
}
