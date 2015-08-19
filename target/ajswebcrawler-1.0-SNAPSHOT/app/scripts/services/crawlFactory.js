/* global ajsWebcrawlApp */

'use strict';

ajsWebcrawlApp.factory('crawlFactory', ['$http', function($http) {

        var urlBase = '/ajswebcrawler/webresources/rest.crawl';
        var crawlFactory = {};
        //----------------------------------------------------------------------
        // Data retrieval section
        //----------------------------------------------------------------------
        
        crawlFactory.getCrawledUrl = function(CrawlRequest) {
            return $http({
                url: urlBase,
                method: 'POST',
                data: CrawlRequest
            });
        };
        
        return crawlFactory;
    }]);