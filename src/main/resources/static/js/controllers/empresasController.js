app.controller('empresasController', ['$uibModal', '$scope', '$http', function ($uibModal, $scope, $http) {
        var ec = this;

        ec.showEmpresasTbl = false;

        ec.empresas = {};

        ec.alerts = [];

        ec.getEmpresas = function() {
            $http.get('/api/empresas')
                .then(function(res) {
                    if (res.data.length > 0) {
                        ec.empresas = res.data;
                        ec.showEmpresasTbl = true;
                    }
                })
                .catch(function(error) {
                    console.log(error);
                });
        };

        ec.getEmpresas();
    }]);
