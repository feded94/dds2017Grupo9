app.controller('indexController', ['$rootScope', '$scope', '$cookieStore', '$location', function ($rootScope, $scope, $cookieStore, $location) {
    $scope.logout = function () {
        $rootScope.globals = {};
        $cookieStore.remove("globals");
        $location.path('/login');
    };
}]);