var appServices = angular.module('SHTezt.services', ['ngResource']);

appServices.factory('Book', ['$resource', function($resource) {
    var Book = $resource('/api/books/:bookId',
                     {bookId: '@id'},
                     {update: {method: 'PUT'}},
                     {query: {method:'GET', isArray:true}}
                    );

    Book.prototype.isNew = function() {
        return (typeof(this.id) === 'undefined');
    }

    return Book;
}]);
