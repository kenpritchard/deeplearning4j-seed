'use strict';

/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */
angular.module('angularApp')
  .controller('MainCtrl', function($scope, $http) {
    $scope.results = [];
    $scope.inputText = '';
    $scope.searchTerm = '';
    $scope.clear = function() {
      $scope.inputText = '';
      $scope.searchTerm = '';
      $scope.results = [];
    };
    $scope.submit = function() {
      $http.post('http://localhost:8080/learnText', {
        targetWord: $scope.searchTerm,
        inputStrings: $scope.inputText.split(/\n/)
      }).
      success(function(data, status, headers, config) {
        $scope.results = data;
      }).
      error(function(data, status, headers, config) {
        $scope.results = [];
      });
    };
    $scope.hasResults = function() {
      return $scope.results.length > 0;
    };
  });
