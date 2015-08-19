'use strict';

/**
 * @ngdoc overview
 * @name ajsWebcrawlApp
 * @description
 * # ajsWebcrawlApp
 *
 * Main module of the application.
 */
var ajsWebcrawlApp = angular.module('ajsWebcrawlApp', [
    'ngRoute'
  ]);

ajsWebcrawlApp.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/views/main.html',
        controller: 'MainCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

