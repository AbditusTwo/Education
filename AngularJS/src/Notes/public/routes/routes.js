/**
 * Created by BKuczynski on 2017-02-17.
 */
module.config(function ($routeProvider) {
    $routeProvider.when('/:section?', {
        templateUrl: 'routes/notes/notes.html',
        controller: 'NotesController'
    }).when('/', {
            templateUrl: 'routes/notes/notes.html',
            controller: 'NotesController'
        }
    ).when('/section/:name', {
        templateUrl: 'routes/viewSection/viewSection.html',
        controller: 'ViewSectionController'
    }).otherwise({redirectTo: '/'});
});