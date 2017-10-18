"use strict";

//alert("service linked");

angular.module("productApp").service("productService",function($http){
//  alert("service called");
  this.getProduct = function(){
    return $http({
      method:"get",
      url:"/project-cubic/product/2"
    }).then(function(result){
      return result.data;
    });
  }
});
