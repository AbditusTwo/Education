var module = angular.module("notesApp", []);

module.controller("NotesController", function ($scope, $http) {
    $scope.notes = [];

    var update = function () {
        $http.get("/notes")
            .then(function (res) {
                $scope.notes = res.data;
            });
    };

    $scope.add = function () {
        var note = {
            text: $scope.text
        };

        $http.post("/notes", note)
            .then(
                function () {
                    $scope.text = "";
                    update();
                }
            );
    };

    $scope.remove = function (id) {
        var note = {
            params: {
                id: id
            }
        };

        $http.delete("/notes", {params: {id: id}})
            .then(
                function () {
                    update();
                }
            );
    };

    $scope.top = function (id) {
        var note = {
            id: id
        }

        $http.put("/notes", note)
            .then(
                function () {
                    update();
                }
            );
    };


    update();
});
