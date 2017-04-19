/**
 * Created by USER on 19-Apr-17.
 */

var app = angular.module("hectorApp", []);

app.controller('MainController', ['$scope', '$http', function ($scope, $http) {
    $scope.mostrarTablaCuentas = false;
    $scope.cuentas = {};

    $scope.loadCuentas = function () {
        $http.get('http://www.mocky.io/v2/58f6f465100000d20e24ef70').then(function (res) {
            $scope.cuentas = res.data;
            $scope.mostrarTablaCuentas = true;
        });
    };
}]);