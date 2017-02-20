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
                .then (
                function () {
                    $scope.text = "";
                    update();
                }
            );
        };

        update();
    });