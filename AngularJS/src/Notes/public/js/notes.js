var module = angular.module("notesApp", ['dndLists']);

module.controller("NotesController", function ($scope, $http) {
    $scope.notes = [];

    var update = function () {
        var params = {params: {section: $scope.activeSection}};
        $http.get("/notes", params)
            .then(function (res) {
                $scope.notes = res.data;
            });
    };

    $scope.add = function () {
        var note = {
            text: $scope.text,
            section: $scope.activeSection
        };

        if (!$scope.text || $scope.text.length == 0) return;

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

    var readSections = function () {
        $http.get("/sections")
            .then(function (sections) {
                $scope.sections = sections.data;
                if ($scope.activeSection == null && $scope.sections.length > 0) {
                    $scope.activeSection = $scope.sections[0].title;
                }
            });
    };

    $scope.showSection = function (section) {
        $scope.activeSection = section.title;
        update();
    };

    $scope.writeSections = function () {
        if ($scope.sections && $scope.sections.length > 0) {
            $http.post("/sections/replace", $scope.sections);
        }
    };

    $scope.addSection = function () {
        if ($scope.newSection.length == 0) return;
        // check for duplicates
        for (var i = 0; i < $scope.sections.length; i++) {
            if ($scope.sections[i].title == $scope.newSection) {
                return;
            }
        }
        var section = {title: $scope.newSection};
        $scope.sections.unshift(section);
        $scope.activeSection = $scope.newSection;
        $scope.newSection = "";
        $scope.writeSections();
        update();
    }

    readSections();
    update();
});
