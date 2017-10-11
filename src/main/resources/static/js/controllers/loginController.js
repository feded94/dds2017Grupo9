app.controller('loginController',
    ['$rootScope', '$http', '$cookies', '$location',
        function ($rootScope, $http, $cookies, $location) {
            var lc = this;

            lc.login = function () {
                lc.dataLoading = true;
                var user = lc.getUser();

                if (user !== null && user.clave === lc.password) {
                    $rootScope.globals = {
                        currentUser: {
                            username: lc.username,
                            password: lc.password
                        }
                    };

                    var cookieExp = new Date();
                    cookieExp.setDate(cookieExp.getDate() + 7);
                    $cookies.putObject('globals', $rootScope.globals, { expires: cookieExp });

                    $location.path('/home');
                }
                else {
                    lc.dataLoading = false;
                }
            };

            lc.getUser = function () {
                return $http.get('/api/usuarios', {
                    params: { username: lc.username }
                });
            };
        }
    ]
);
