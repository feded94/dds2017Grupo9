app.controller('homeController', ['$rootScope', '$scope', '$state', '$http', function ($rootScope, $scope, $state, $http) {
        var hc = this;
        hc.showCuentasTbl = false;
        hc.cuentas = {};
        hc.showIndicadoresTbl = false;
        hc.indicadores = {};

        hc.loadCuentas = function () {
            $http.get('/api/cuentas')
                .then(function (res) {
                hc.cuentas = res.data;
                hc.showCuentasTbl = true;
                })
                .catch(function(error){
                    console.log(error);
                });
        };
        hc.loadTables = function () {
            hc.loadCuentas();
            hc.loadIndicadores();
        };
        hc.loadIndicadores = function () {
            $http.get('/api/indicadores')
                .then(function (res) {
                    hc.indicadores = res.data;
                    hc.showIndicadoresTbl = true;
                })
                .catch(function(error){
                    console.log(error);
                });
        };
}]);