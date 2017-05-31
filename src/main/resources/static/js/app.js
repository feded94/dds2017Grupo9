/**
 * Created by USER on 19-Apr-17.
 */

var app = angular.module("hectorApp", []);

app.controller('MainController', ['$scope', '$http', function ($scope, $http) {
    $scope.mostrarTablaCuentas = false;
    $scope.cuentas = {};

    $scope.loadCuentas = function () {
        $http.get('/cuentas').then(function (res) {
            $scope.cuentas = res.data;
            $scope.mostrarTablaCuentas = true;
        });
    };
}]);