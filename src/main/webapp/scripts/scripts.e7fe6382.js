"use strict";angular.module("angularApp",["ngAnimate","ngCookies","ngResource","ngRoute","ngSanitize","ngTouch","ui.sortable","LocalStorageModule"]).config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/main.html",controller:"MainCtrl"}).when("/about",{templateUrl:"views/about.html",controller:"AboutCtrl"}).otherwise({redirectTo:"/"})}]).config(["localStorageServiceProvider",function(a){a.setPrefix("ls")}]),angular.module("angularApp").controller("HeaderController",["$scope","$location",function(a,b){a.isActive=function(a){var c=b.path();return a===c}}]),angular.module("angularApp").controller("MainCtrl",["$scope",function(a){a.results=[],a.inputText="",a.searchTerm="",a.clear=function(){a.inputText="",a.searchTerm="",a.results=[]},a.submit=function(){a.results=a.inputText.split(/\n/)},a.hasResults=function(){return a.results.length>0}}]),angular.module("angularApp").controller("AboutCtrl",function(){});