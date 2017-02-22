module.directive("matchTo", function () {
    return {
        require: "ngModel",
        scope: {
            otherValue: "=matchTo"
        },
        link: function (scope, element, attributes, ngModel) {
            ngModel.$validators.matchTo = function (modelValue) {
                console.log(modelValue)
                console.log(scope.otherValue)
                return modelValue == scope.otherValue;
            };

            scope.$watch("otherValue", function () {
                ngModel.$validate();
            })
        }
    };
});

module.directive("uniqueUser", function ($http, $timeout) {
    var timer;
    return {
        restrict: "A",
        require: "ngModel",
        link: function (scope, elem, attr, ctrl) {
            scope.$watch(attr.ngModel, function (value) {
                if (timer) $timeout.cancel(timer);

                timer = $timeout(function () {
                    $http.get("/checkUser?user=" + value)
                        .then(function (res) {
                            console.log(res);
                            console.log(ctrl);
                            ctrl.$setValidity("unique", res.data);
                        });
                }, 200);
            })
        }
    };
});

module.directive("uniqueUserAsync", function ($http, $q) {
    var timer;
    return {
        restrict: "A",
        require: "ngModel",
        link: function (scope, elem, attr, ngModel) {
            ngModel.$asyncValidators.unique = function (modelValue, viewValue) {
                var value = modelValue || viewValue;
                return $http.get("/checkUser?user=" + value)
                    .then(function (res) {
                        if (!res.data) {
                            return $q.reject("To short");
                        }
                        return true;
                    });
            };
        }
    };
});

module.directive("adultUser", function () {
    var timer;
    return {
        restrict: "A",
        require: "ngModel",
        link: function (scope, elem, attr, ngModel) {
        ngModel.$validators.adultUser = function (modelValue) {
                if (modelValue) {
                    var yearsAgo = moment().substract(attributes.adultUser, 'year')
                    return moment(modelValue).isBefore(yearsAgo);
                    }
                    else {
                    }
                        });
                }, 200);
            })
        }
    };
});

module.controller("UserFormController", function ($scope, $http, $location) {
    $scope.user = {};

    $scope.submitForm = function () {
        $http.post("/users", $scope.user)
            .then(function (res) {
                console.log("saved!");
                $location.path("/");
            });
    }
});