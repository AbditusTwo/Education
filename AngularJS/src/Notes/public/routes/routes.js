/**
 * Created by BKuczynski on 2017-02-17.
 */
module.config(function ($routeProvider) {
    $routeProvider.when('/', {
            templateUrl: 'routes/notes/notes.html',
            controller: 'NotesController'
        }
    ).when('/register', {
        templateUrl: 'routes/userForm/userForm.html',
        controller: 'UserFormController'
    }).when('/:section?', {
        templateUrl: 'routes/notes/notes.html',
        controller: 'NotesController'
    }).when('/section/:name', {
        templateUrl: 'routes/viewSection/viewSection.html',
        controller: 'ViewSectionController'
    }).otherwise({redirectTo: '/'});
});