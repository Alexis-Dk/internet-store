import angular from 'angular';

class RightCtrl {
  /* @ngInject */
  constructor($scope, $timeout, $mdSidenav, $log) {
    $scope.close = function () {
      // Component lookup should always be available since we are not using `ng-if`
      $mdSidenav('right').close()
        .then(function () {
          $log.debug("close RIGHT is done");
        });
    };
  }
}

angular.module('customMenu').controller('RightCtrl', RightCtrl);
