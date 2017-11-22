app.controller('homeController', ['$rootScope', '$scope', '$state', '$http', function ($rootScope, $scope, $state, $http) {
        var hc = this;
        hc.showCuentasTbl = false;
        hc.cuentas = {};
        hc.showIndicadoresTbl = false;
        hc.indicadores = {};

        hc.loadCuentas = function () {
            var params = new Object();

            if (hc.empresa)
                params.empresa = hc.empresa;
            if (hc.periodo)
                params.periodo = hc.periodo;

            $http.get('/api/cuentas', {
                params: params
            })
                .then(function(res) {
                    hc.showCuentasTbl = res.data.length > 0;
                    hc.cuentas = res.data;
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
            if (hc.empresa && hc.periodo)
                $http.get('/api/indicadores', {
                    params: {
                        empresa: hc.empresa,
                        periodo: hc.periodo,
                        usuario: $rootScope.globals.currentUser.username
                    }
                })
                    .then(function (res) {
                        hc.indicadores = res.data;
                        hc.showIndicadoresTbl = true;
                    })
                    .catch(function(error){
                        console.log(error);
                    });
        };
}]);