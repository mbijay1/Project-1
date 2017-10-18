"use strict";
//alert("from App");
angular.module("productApp",['ngRoute']);
angular.module("productApp").config(
  function($routeProvider) {
    $routeProvider
    .when("/home", {
        templateUrl : "home.html"
    })
    .when("/product", {
        templateUrl : "product.html",
        controller : "productController"
    })
    .when("/addEditProduct", {
        templateUrl : "addEdit.html",
        controller: "addEditController"
    })
    .when("/about", {
        templateUrl : "contactUs.html"
    });
}
);
