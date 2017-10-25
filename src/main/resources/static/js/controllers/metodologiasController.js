app.controller('metodologiasController', ['$uibModal', '$scope', '$http', '$rootScope', function ($uibModal, $scope, $http, $rootScope) {
    var mc = this;

    mc.openModalAddMetodologia = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'modalFormMetodologia.html',
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
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
}]);
