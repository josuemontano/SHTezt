var appControllers = angular.module('SHTezt.controllers', []);


appControllers.controller('HomeController', [function (){
    
}]);

appControllers.controller('BookListController', ['$scope', 'Book',  function ($scope, Book){
    $scope.books     = Book.query();
    $scope.predicate = 'title';

    $scope.deleteBook = function(book) {
        var deletebook = confirm('Are you absolutely sure you want to delete this book?');   
        if (deletebook) {
            $scope.books.splice($scope.books.indexOf(book), 1);
        }
    }
}]);

appControllers.controller('BookEditController', ['$scope', '$routeParams', '$location', 'Book',  function ($scope, $routeParams, $location, Book){
    var bookId = $routeParams.bookId;
    
    if (bookId === 'new') $scope.book = new Book();
    else                  $scope.book = Book.get({bookId: bookId});

    $scope.save = function () {
        if ($scope.book.isNew()) {
            $scope.book.$save(function (book, headers) { });
        } else {
            $scope.book.$update(function() { });
        }

        $location.path('books');
    }
    
}]);
