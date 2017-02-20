var module = angular.module("notesApp, []");

module.controller("NotesController", function ($scope, $http) {
    $scope.notes = [];

    var update = function () {
        $http.get("/notes")
            .then(function (res) {
                $scope.notes = res.data;
            });
        }

        update();
    });