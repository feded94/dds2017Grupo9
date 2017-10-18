var app = angular.module('app', ['ngCookies', 'ui.router', 'ui.bootstrap']);

app
    .config(
    ['$stateProvider', '$locationProvider', '$urlRouterProvider',
        function ($stateProvider, $locationProvider, $urlRouterProvider) {

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
                })

                .state('login', {
                    url: '/login',
                    templateUrl: 'views/login.html',
                    controller: 'loginController',
                    controllerAs: 'lc'
                });

            $urlRouterProvider.otherwise('/login');
        }
    ]
)
.run(['$rootScope', '$location', '$cookieStore', '$http', function ($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        // redirect to login page if not logged in and trying to access a restricted page
        var restrictedPage = $.inArray($location.path(), ['/login']) === -1;
        var loggedIn = $rootScope.globals.currentUser;
        if (restrictedPage && !loggedIn) {
            $location.path('/login');
        }
    });
}]);