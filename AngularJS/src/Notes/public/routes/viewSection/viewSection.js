/**
 * Created by BKuczynski on 2017-02-17.
 */

module.controller("ViewSectionController",
    function ($scope, $http, $routeParams) {
        $scope.section = $routeParams.name;
        var params = {params: {section: $routeParams.name}};
        $http.get("/notes", params)
            .then(function (notes) {
                $scope.notes = notes;
            });
    }
);