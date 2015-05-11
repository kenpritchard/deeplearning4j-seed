'use strict';

angular.module('angularApp')
  .controller('HeaderController', function ($scope, $location) {
    $scope.isActive = function (viewLocation) {
    	var currentPath = $location.path();
      return viewLocation === currentPath;
    };
  });
