var app = angular.module('app', ['ui.router', 'ui.bootstrap']);

app.config(['$stateProvider', '$locationProvider', '$urlRouterProvider', function ($stateProvider, $locationProvider, $urlRouterProvider) {

        $stateProvider
        // HOME STATES AND NESTED VIEWS ========================================
            .state('home', {
                url: '/home',
                templateUrl: 'views/home.html',
                controller: 'homeController',
                controllerAs: 'hc'
            })

            // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
            .state('indicadores', {
                url: '/indicadores',
                templateUrl: 'views/indicadores.html',
                controller: 'indicadoresController',
                controllerAs: 'ic'
            })

            .state('empresas', {
                url: '/empresas',
                templateUrl: 'views/empresas.html',
                controller: 'empresasController',
                controllerAs: 'ec'
            });

        $urlRouterProvider.otherwise('/home');

}]);