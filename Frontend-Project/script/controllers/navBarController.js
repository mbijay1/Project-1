"use strict";
// alert("from outside  nbc");
angular.module("productApp").controller("navBarController", function($scope, productService){
  // alert("from inside nbc");
  $scope.addEditProduct = function(){
    productService.prctMdl =  {
      activeDate:"",
      category:"LAPTOPS",
      createdDate:"",
      currentQuantity:"",
      inactiveDate:"",
      manufacturer:"HP",
      orderedQuantity:"",
      price:"",
      productName:"",
      productNumber:"",
      thresholdQuantity:"",
      upc:"",
      version:"",
      description:"",
      activeState:"false"
    };
    productService.showAButton = true;
    productService.showDateRow = false;
    console.log("button clicked");
    console.log(productService.showAButton);
  }
});
