/* global ajsWebcrawlApp */

'use strict';

/**
 * @ngdoc function
 * @name ajsWebcrawlApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the ajsWebcrawlApp
 */
ajsWebcrawlApp.controller('MainCtrl', ['$scope', 'crawlFactory',
    function ($scope, crawlFactory) {
        $scope.url = "http://devops.ph";
        $scope.message = "";     
        $scope.CrawlRequest = {
            urlToCrawl: ''
        };        

        $scope.crawl = function () {
            
            $scope.CrawlRequest.urlToCrawl = $scope.url;
            
            crawlFactory.getCrawledUrl($scope.CrawlRequest)
                    .success(function (CrawlListResponse) {
                        $scope.crawledUrl = CrawlListResponse;
                    })
                    .error(function () {
                        $scope.crawledUrl = "Error getting detials.";
                    });
        };

    }]);
