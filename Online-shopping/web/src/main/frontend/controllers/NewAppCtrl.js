'use strict';

import angular from 'angular';

class NewAppCtrl {
  /* @ngInject */
  constructor($scope, $timeout, $mdSidenav, $log, $http) {


$scope.selected = [];
$scope.selected1 = [];
$scope.selected2 = [];
$scope.selected3 = [];
$scope.selected4 = [];
$scope.selected5 = [];
$scope.selected6 = [];
$scope.selected7 = [];

    this.$http = $http;
    this.$scope = $scope;

    $scope.getCharacteristic1 = () => {
      let params = {};
      $http.get('api/accounts/characteristic1', {params})
        .then(resp => {
              $scope.items1 = resp.data.characteristics1.toString().split(" ");
        });
    };
    $scope.getCharacteristic1();

    $scope.getSelectedCharacteristic1 = () => {
      let params = {};
      $http.get('api/accounts/selectedCharacteristic1', {params})
        .then(resp => {
          var x1 = resp.data.selectedCharacteristics1.toString().split(" ");
          for (let index in x1) {
            $scope.selected1.push(x1[index]);
          }
        });
    };
    $scope.getSelectedCharacteristic1();

    $scope.getCharacteristic2 = () => {
      let params = {};

      $http.get('api/accounts/characteristic2', {params})
        .then(resp => {
              $scope.items2 = resp.data.characteristics2.toString().split(" ");
        });
    };
    $scope.getCharacteristic2();

    $scope.getSelectedCharacteristic2 = () => {
      let params = {};
      $http.get('api/accounts/selectedCharacteristic2', {params})
        .then(resp => {
          var x1 = resp.data.selectedCharacteristics2.toString().split(" ");
          for (let index in x1) {
            $scope.selected2.push(x1[index]);
          }
           $scope.y=$scope.selected2.join("+");
        });
    };
    $scope.getSelectedCharacteristic2();

    $scope.getCharacteristic3 = () => {
      let params = {};
      $http.get('api/accounts/characteristic3', {params})
        .then(resp => {
              $scope.items3 = resp.data.characteristics3.toString().split(" ");
        });
    };
    $scope.getCharacteristic3();

    $scope.getSelectedCharacteristic3 = () => {
      let params = {};

      $http.get('api/accounts/selectedCharacteristic3', {params})
        .then(resp => {
          var x1 = resp.data.selectedCharacteristics3.toString().split(" ");
          for (let index in x1) {
            $scope.selected3.push(x1[index]);
          }
        });
    };
    $scope.getSelectedCharacteristic3();

    $scope.getCharacteristic4 = () => {
      let params = {};

      $http.get('api/accounts/characteristic4', {params})
        .then(resp => {
              $scope.items4 = resp.data.characteristics4.toString().split(" ");
        });
    };
    $scope.getCharacteristic4();

    $scope.getSelectedCharacteristic4 = () => {
      let params = {};

      $http.get('api/accounts/selectedCharacteristic4', {params})
        .then(resp => {
          var x1 = resp.data.selectedCharacteristics4.toString().split(" ");
          for (let index in x1) {
            $scope.selected4.push(x1[index]);
          }
        });
    };
    $scope.getSelectedCharacteristic4();

    $scope.getCharacteristic5 = () => {
      let params = {};
      $http.get('/Internet-store/api/accounts/characteristic5', {params})
        .then(resp => {
              $scope.items5 = resp.data.characteristics5.toString().split(" ");
        });
    };
    $scope.getCharacteristic5();

    $scope.getSelectedCharacteristic5 = () => {
      let params = {};
      $http.get('api/accounts/selectedCharacteristic5', {params})
        .then(resp => {
          var x1 = resp.data.selectedCharacteristics5.toString().split(" ");
          for (let index in x1) {
            $scope.selected5.push(x1[index]);
          }
        });
    };
    $scope.getSelectedCharacteristic5();

    $scope.getCharacteristic6 = () => {
      let params = {};
      $http.get('api/accounts/characteristic6', {params})
        .then(resp => {
              $scope.items6 = resp.data.characteristics6.toString().split(" ");
        });
    };
    $scope.getCharacteristic6();

    $scope.getSelectedCharacteristic6 = () => {
      let params = {};
      $http.get('api/accounts/selectedCharacteristic6', {params})
        .then(resp => {
          var x1 = resp.data.selectedCharacteristics6.toString().split(" ");
          for (let index in x1) {
            $scope.selected6.push(x1[index]);
          }
        });
    };
    $scope.getSelectedCharacteristic6();

    $scope.getCharacteristic7 = () => {
      let params = {};
      $http.get('api/accounts/characteristic7', {params})
        .then(resp => {
              $scope.items7 = resp.data.characteristics7.toString().split(" ");
        });
    };
    $scope.getCharacteristic7();

    $scope.getSelectedCharacteristic7 = () => {
      let params = {};
      $http.get('api/accounts/selectedCharacteristic7', {params})
        .then(resp => {
          var x1 = resp.data.selectedCharacteristics7.toString().split(" ");
          for (let index in x1) {
            $scope.selected7.push(x1[index]);
          }
        });
    };
    $scope.getSelectedCharacteristic7();

      $scope.toggle2 = function (item, list) {
       var idx = list.indexOf(item);
        //var idx = item;
        if (idx > -1) {
          list.splice(idx, 1);
        }
        else {
          list.push(item);
        }
              $scope.x=list.join();
      };

      $scope.exists2 = function (item, list) {
        return list.indexOf(item) > -1;
      };


    $scope.fetch = () => {
      let params = {};

      $http.get('api/accounts', {params})
        .then(resp => {
          this.accounts = resp.data;
          $scope.z=this.accounts;
        });
    };

    $scope.fetch();

    $scope.fetch2 = () => {
      let params = {};

      $http.post('api/accounts', {params})
        .then(resp => {
          var arr = [];
          var x1 = resp.data.title.toString().split(" ");
          $scope.userFindData = resp.data;
          for (let index in x1) {
            $scope.selected.push(x1[index]);
          }
          arr.push(x1);
           $scope.x=$scope.selected.join();
        });
    };

    $scope.fetch2();

        $scope.fetch();

    $scope.fetch3 = () => {
      let params = {};

      $http.post('api/accounts/customUserData', {params})
        .then(resp => {
        	$scope.customUserParam = resp.data;
        });
    };
    $scope.fetch3();

    $scope.updateBoolChar1 = () => {
      let params = {};
      $http.post('api/accounts/boolStatusUpdateChar1', {params})
        .then(resp => {
          $scope.customUserParam = resp.data;
        });
    };

    $scope.updateBoolChar2 = () => {
      let params = {};
      $http.post('api/accounts/boolStatusUpdateChar2', {params})
        .then(resp => {
          $scope.customUserParam = resp.data;
        });
    };

    $scope.updateBoolChar3 = () => {
      let params = {};
      $http.post('api/accounts/boolStatusUpdateChar3', {params})
        .then(resp => {
          $scope.customUserParam = resp.data;
        });
    };

    $scope.updateBoolChar4 = () => {
      let params = {};
      $http.post('api/accounts/boolStatusUpdateChar4', {params})
        .then(resp => {
          $scope.customUserParam = resp.data;
        });
    };

    $scope.updateBoolChar5 = () => {
      let params = {};
      $http.post('api/accounts/boolStatusUpdateChar5', {params})
        .then(resp => {
          $scope.customUserParam = resp.data;
        });
    };

    $scope.items = ['LG','Panasonic','Samsung','Sony','BBK'];

      $scope.x=$scope.selected.join();

      $scope.toggle = function (item, list) {
       var idx = list.indexOf(item);
        //var idx = item;
        if (idx > -1) {
          list.splice(idx, 1);
        }
        else {
          list.push(item);
        }
              $scope.x=list.join();
      };

      $scope.exists = function (item, list) {
        return list.indexOf(item) > -1;
      };

	$scope.user = {
	      title: 'Developer',
	      email: 'ipsum@lorem.com'
	    };

  }

    fetch() {
      this.$http.get('api/accounts')
        .then(resp => {
          this.accounts = resp.data;
        });
    };


}


angular.module('customMenu').controller('NewAppCtrl', NewAppCtrl);
