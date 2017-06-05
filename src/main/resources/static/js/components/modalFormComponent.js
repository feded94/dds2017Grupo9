    app
    .component('modalFormComponent', {
    templateUrl: 'modalForm.html',
    bindings: {
        resolve: '<',
        close: '&',
        dismiss: '&'
    },
    controller: function () {
        var modalForm = this;

        modalForm.$onInit = function () {

        };

        modalForm.ok = function () {
            //Llamada al servicio backend de Indicadores (vista indicadores)

            /*$http.post('/api/indicadores', data, config)
                .then(function (res) {
                    //cerrar modal
                })
                .catch(function(error){
                    //mostrar error
                    console.log(error);
                });
            modalForm.close({$value: modalForm.selected.item});*/
        };

        modalForm.cancel = function () {
            modalForm.dismiss({$value: 'cancel'});
        };
    }
});