app.controller('homeController', ['$rootScope', '$scope', '$state', '$http', function ($rootScope, $scope, $state, $http) {
        var hc = this;
        hc.showCuentasTbl = false;
        hc.cuentas = {};
        hc.showIndicadoresTbl = false;

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
}]);