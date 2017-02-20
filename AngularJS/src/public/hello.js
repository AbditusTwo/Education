angular.module("myapp", [])
    .controller("HelloController", function ($scope, $http) {
        $scope.greeting = "";

        $scope.update = function () {
            if ($scope.name) {
                $http.get('/greeting', {
                    params: {
                        name: $scope.name
                }
                }).then(function (res) {
                    $scope.greeting = res.data;
                });
            }
        }
    });