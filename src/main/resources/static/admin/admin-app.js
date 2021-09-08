const app = angular.module('admin-app', ['ngRoute']);
app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "/admin/admin.html"
        })
        .when("/home", {
            templateUrl: "/admin/admin.html"
        })
        .when("/quyenshop/index", {
            redirectTo: function() {
                window.location = "/quyenshop/index";
            }
        })
     
        .when("/product", {
            templateUrl: "/admin/product/product.html",
            controller: "prod-ctrl"
        })
     
        
        .when("/authorize", {
            templateUrl: "/admin/authority/authority.html",
            controller: "authority-ctrl"
        })
        .when("/index", {
            redirectTo: function() {
                window.location = "/quyenshop/index";
            }
        })

        .when("/users", {
            templateUrl: "/admin/user/user.html",
            controller: "users-ctrl"
        })
        
        .otherwise({
            redirectTo: '/quyenshop/admin/home'
        });

});

app.controller("admin-ctrl", function($scope, $http) {
    $scope.tables = []
    $scope.user = []
    $scope.loadTable = function() {
        $http.get(`/quyenshop/admin/tbl`).then(resp => {
            $scope.tables = resp.data;
            console.log("Success", resp);
        }).catch(err => {
            console.log("Error", err);
        })


        $http.get(`/quyenshop/admin/user`).then(resp => {
            $scope.user = resp.data;
            console.log("User", resp)
        }).catch(err => {
            console.log("Err", err);
        })
    }
    $scope.loadTable();
});