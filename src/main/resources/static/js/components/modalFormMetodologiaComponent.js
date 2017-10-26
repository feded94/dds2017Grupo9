app
    .component('modalFormMetodologiaComponent', {
        templateUrl: 'modalFormMetodologia.html',
        bindings: {
            resolve: '<',
            close: '&',
            dismiss: '&'
        },
        controller: function () {
            var modalFormMetodologia = this;

            modalFormMetodologia.$onInit = function () {

            };

            modalFormMetodologia.ok = function () {
            };

            modalFormMetodologia.cancel = function () {
                modalFormMetodologia.dismiss({$value: 'cancel'});
            };
        }
    });