app
.controller('indicadoresController', ['$uibModal', '$scope', '$http', function ($uibModal, $scope, $http) {
        var ic = this;

        ic.showIndicadoresTbl = false;

        ic.indicadores = {};

        //GET lista de indicadores del backend (archivo o bd)
        /*$http.get('/api/indicadores')
        .then(function (res) {
            ic.indicadores = res.data;
            ic.showIndicadoresTbl = true;
        })
        .catch(function(error){
            console.log(error);
        }); */

        ic.openModalAddIndicador = function () {
            var modalInstance = $uibModal.open({
                animation: true,
                component: 'modalFormComponent'
            });

            modalInstance.result.then(function (selectedItem) {
                console.log(selectedItem);
            }, function () {
                console.log('modal-component dismissed at: ' + new Date());
            });
        };
}]);