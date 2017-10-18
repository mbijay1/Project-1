"use strict";
//alert("form ctrl outside");
angular.module("productApp").controller("productCtrl", function($scope, productService){
  //alert("from ctrl inside");
  $scope.productList = [];
  $scope.showTable = true;
  $scope.showAdd = false;
  $scope.showDescription = true;
  $scope.productModel = {}
  $scope.testProductList = [];
  $scope.productToDisplay;
  $scope.search=[];
  $scope.searchBy="$";
  $scope.productListFromDataBase = [];

  productService.getProduct().then(function(data){
    $scope.productListFromDataBase = data;
  })

  $scope.testProductList.push({
    ACTIVE_DATE:"aaa",
    CATEGORY:"bb",
    CREATED_DATE:"cc",
    CURRENT_QUANTITY:"dd",
    INACTIVE_DATE:"ee",
    MANUFACTURER:"ff",
    ORDERED_QUANTITY:"ggg",
    PRICE:"hhhh",
    PRODUCTNAME:"iiii",
    PRODUCTNUMBER:"jj",
    THRESHOLDQUANTITY:"kkk",
    UPC:"asdf",
    VERSION:"sss",
    DESCRIPTION:"Description from product 1",
    PK:"1"
  });

  $scope.testProductList.push({
    ACTIVE_DATE:"adf",
    CATEGORY:"asdf",
    CREATED_DATE:"asdf",
    CURRENT_QUANTITY:"ghlkj",
    INACTIVE_DATE:"ee",
    MANUFACTURER:"ff",
    ORDERED_QUANTITY:"ggg",
    PRICE:"hhhh",
    PRODUCTNAME:"TEST",
    PRODUCTNUMBER:"123",
    THRESHOLDQUANTITY:"kkk",
    UPC:"456",
    VERSION:"sss",
    DESCRIPTION:"Description from product 2",
    PK:"2"
  });

  initEmptyProductModel();
  //updateProductList();  to be called after rest api is used
  function initEmptyProductModel(){
    $scope.productModel = {
      ACTIVE_DATE:"",
      CATEGORY:"",
      CREATED_DATE:"",
      CURRENT_QUANTITY:"",
      INACTIVE_DATE:"",
      MANUFACTURER:"",
      ORDERED_QUANTITY:"",
      PRICE:"",
      PRODUCTNAME:"",
      PRODUCTNUMBER:"",
      THRESHOLDQUANTITY:"",
      UPC:"",
      VERSION:"",
      DESCRIPTION:""
    }
  }
  function updateProductList(){
    //will update $scope.productList = [];
  }

  function updateTestProductList(){
    $scope.testProductList.push({
      ACTIVE_DATE:"adf",
      CATEGORY:"asdf",
      CREATED_DATE:"asdf",
      CURRENT_QUANTITY:"ghlkj",
      INACTIVE_DATE:"ee",
      MANUFACTURER:"ff",
      ORDERED_QUANTITY:"ggg",
      PRICE:"hhhh",
      PRODUCTNAME:"iiii",
      PRODUCTNUMBER:"jj",
      THRESHOLDQUANTITY:"kkk",
      UPC:"asdf",
      VERSION:"sss",
      DESCRIPTION:"Description from product 3",
      PK:"2"
    });
  }

  $scope.addButton = function(){
      $scope.showAdd = true;
  }

  $scope.saveAdd = function(){
      $scope.showAdd = false;
      console.log($scope.productModel);
      //call rest API to add the product in database
      //call updateProductList
      initEmptyProductModel();
  }
  $scope.cancelAdd = function(){
      $scope.showAdd = false;
      initEmptyProductModel();
  }

  $scope.showDescriptionMethod = function(productModel){
      $scope.showDescription = false;
      $scope.showTable = false;
      $scope.productToDisplay = angular.copy(productModel);
      console.log("print this");
  }

  $scope.descriptionSaveButton = function(){
    $scope.showDescription = true;
    $scope.showTable = true;
    //call put rest api to update
    //call updateProductList
  }

  $scope.descriptionCancelButton = function(){
    $scope.showDescription = true;
    $scope.showTable = true;
  }
});
