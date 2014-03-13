angular
.module('SHTezt', [
    'ngRoute',
    'SHTezt.services',
    'SHTezt.controllers',
])
.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/views/home/index.html',
            controller: 'HomeController'
        })
        .when('/books', {
            templateUrl: '/views/books/list.html',
            controller: 'BookListController'
        })
        .when('/books/:bookId', {
            templateUrl: '/views/books/edit.html',
            controller: 'BookEditController'
        })
        .otherwise({
            redirectTo: '/'
        });
});
