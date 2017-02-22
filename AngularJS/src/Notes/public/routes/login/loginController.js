module.controller("LoginController", function ($scope, UserService, $location, $route, $timeout) {
    $scope.loggedIn = UserService.loggedIn;

    var successfulLogin = function () {
        $scope.loggedIn = true;
        $location.path("/");
        $route.reload();
    };
    var unsuccessfulLogin = function () {
        $scope.wrongPassword = true;
        $timeout(function () {
            $scope.wrongPassword = false;
        }, 1000);
    };

    $scope.login = function () {
        UserService.login($scope.login, $scope.password)
            .then(successfulLogin, unsuccessfulLogin);
    };

    $scope.logout = function () {
        UserService.logout($scope.login, $scope.password)
            .then(function () {
                $scope.loggedIn = false;
                $location.path("/");
                $route.reload();
            });
    }
});