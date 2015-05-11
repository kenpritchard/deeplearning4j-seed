'use strict';

/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */
angular.module('angularApp')
  .controller('MainCtrl', function ($scope) {
    $scope.results = [];
    $scope.inputText = '';
      $scope.searchTerm = '';
    $scope.clear = function() {
      $scope.inputText = '';
        $scope.searchTerm = '';
        $scope.results = [];
      };
    $scope.submit  = function() {
      $scope.results = $scope.inputText.split(/\n/);
      };
    $scope.hasResults  = function() {
      return $scope.results.length > 0;
      };
  });
