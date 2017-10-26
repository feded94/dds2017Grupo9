app.controller('metodologiasController', ['$uibModal', '$scope', '$http', '$rootScope', function ($uibModal, $scope, $http, $rootScope) {
    var mc = this;

    mc.showMetodologiasTbl = false;
    mc.metodologias = {};
    mc.operadores = [];
    mc.selectOperador = "";

    mc.getMetodologias = function () {
        $http.get('/api/metodologias')
            .then(function (res) {
                if (res.data.length > 0) {
                    mc.metodologias = res.data;
                    mc.showMetodologiasTbl = true;
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    mc.getOperadores = function () {
        $http.get('/api/operadores')
            .then(function (res) {
                if (res.data.length > 0) {
                    mc.operadores = res.data;
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    mc.openModalAddMetodologia = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'modalFormMetodologia.html',
            ariaLabelledBy: 'modal-title-metodologias',
            ariaDescribedBy: 'modal-body-metodologias',
            controller: 'metodologiasController',
            controllerAs: 'mc'
        });

        modalInstance.result.then(function () {
            console.log("OK");
            mc.getMetodologias();
        }, function () {
            console.log('modal-component dismissed at: ' + new Date());
        });
    };

    mc.cancel = function (handler) {
        handler.$dismiss();
    };

    mc.getMetodologias();
    mc.getOperadores();
}]);
