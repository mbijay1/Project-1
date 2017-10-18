"use strict";
//alert("form ctrl outside");
angular.module("productApp").controller("productCtrl", function($scope, productService){
  //alert("from ctrl inside");
  $scope.showTable = true;
  $scope.showAdd = false;
  $scope.showDescription = true;
  $scope.productModel = {}
  $scope.editProductModel;
  $scope.search=[];
  $scope.searchBy="$";
  $scope.productListFromDataBase = [];

  updateProductList();



  initEmptyProductModel();
  //updateProductList();  to be called after rest api is used
  function initEmptyProductModel(){
    $scope.productModel = {
      activeDate:"",
      category:"",
      createdDate:"",
      currentQuantity:"",
      inactiveDate:"",
      manufacturer:"",
      orderedQuantity:"",
      price:"",
      productName:"",
      productNumber:"",
      thresholdQuantity:"",
      upc:"",
      version:"",
      description:""
    }
  }

  function updateProductList(){
    productService.getProduct().then(function(data){

    $scope.productListFromDataBase = data.products;

    })
  }

  $scope.addButton = function(){
      $scope.showAdd = true;
  }

  $scope.saveAdd = function(){
      $scope.showAdd = false;
      console.log($scope.productModel);
      productService.postProduct($scope.productModel).then(function(){
        updateProductList();
      });
      //call rest API to add the product in database
      //call updateProductList
      initEmptyProductModel();
  }

  $scope.cancelAdd = function(){
      $scope.showAdd = false;
      initEmptyProductModel();
  }
  $scope.delete = function(){
    $scope.showDescription = true;
    $scope.showTable = true;
      productService.deleteProduct($scope.editProductModel.pk).then(function(){
        updateProductList();
      });

  }

  $scope.showDescriptionMethod = function(productModel){
      $scope.showDescription = false;
      $scope.showTable = false;
      $scope.editProductModel = angular.copy(productModel);
      console.log("print this");
  }

  $scope.descriptionSaveButton = function(){
    $scope.showDescription = true;
    $scope.showTable = true;
    productService.putProduct($scope.editProductModel).then(function(){
      updateProductList();
    });

    //call put rest api to update
    //call updateProductList
  }


  $scope.descriptionCancelButton = function(){
    $scope.showDescription = true;
    $scope.showTable = true;
  }
});
