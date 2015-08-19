/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajscrawler.impl;

import com.ajscrawler.bean.response.CrawlListResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kim
 */
public class CrawlerImplTest {
    
    public CrawlerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crawl method, of class CrawlerImpl.
     */
    @Test
    public void testCrawl() {
        CrawlerImpl instance = new CrawlerImpl("http://devops.ph");
        CrawlListResponse result = instance.crawl();
        assertEquals(3, result.getLstCrawlResponse().size());
    }
}
