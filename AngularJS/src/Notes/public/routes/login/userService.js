module.factory("UserService", function ($http, $rootScope, $timeout, $q) {
    var service = {};

    service.userName = "";
    service.loggedIn = false;

    service.login = function (login, password) {
        var deferred = $q.defer();
        $http.post("/login", {login: login, password: password})
            .then(function (res) {
                if (res) {
                    service.loggedIn = true;
                    service.userName = login;
                    console.log("logged in");
                    deferred.resolve("logged in");
                } else {
                    console.log("Wrong username/password");
                    deferred.reject("Wrong username/password");
                }
            });

        return deferred.promise;
    };

    service.logout = function () {
        return $http.get("/logout");
    };

    return service;
});