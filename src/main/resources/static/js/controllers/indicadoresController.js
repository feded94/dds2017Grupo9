app.controller('indicadoresController', ['$uibModal', '$scope', '$http', '$rootScope', function ($uibModal, $scope, $http, $rootScope) {
        var ic = this;

        ic.showIndicadoresTbl = false;

        ic.indicadores = {};

        ic.alerts = [];

        ic.getIndicadores = function () {
            //GET lista de indicadores del backend
            $http.get('/api/indicadores')
                .then(function (res) {
                    if (res.data.length > 0) {
                        ic.indicadores = res.data;
                        ic.showIndicadoresTbl = true;
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        };

        ic.openModalAddIndicador = function () {
            var modalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'modalForm.html',
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                controller: 'indicadoresController',
                controllerAs: 'ic'
            });


            modalInstance.result.then(function () {
                console.log("OK");
                ic.getIndicadores();
            }, function () {
                console.log('modal-component dismissed at: ' + new Date());
            });
        };

        ic.ok = function (handler) {
            //Llamada al servicio backend de Indicadores (vista indicadores)
            const data = {"nombre": ic.inputNombre, "regla": ic.inputExpresion, "username": $rootScope.globals.currentUser.username};
            const config = {"Content-Type": "application/json"};

            $http.post('/api/indicadores', data, config)
                .then(function (res) {
                    handler.$close();
                })
                .catch(function (error) {
                    //mostrar error
                    var msgError = error.data.message;
                    ic.alerts.push({msg: msgError, type: 'danger'});
                    console.log(msgError);
                });

        };

        ic.cancel = function (handler) {
            handler.$dismiss();
        };

        ic.closeAlert = function(index) {
            ic.alerts.splice(index, 1);
        };

        ic.getIndicadores();
    }]);