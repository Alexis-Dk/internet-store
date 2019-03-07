import angular from 'angular';

class MyController {
  /* @ngInject */
  constructor($scope, $mdSidenav) {
    $scope.openLeftMenu = function() {
      $mdSidenav('left').toggle();
    };
  }
}

angular.module('customMenu').controller('MyController', MyController);
