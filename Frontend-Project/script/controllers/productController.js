"use strict";
// alert("from outside pc");
angular.module("productApp").controller("productController", ["$scope","productService", function(spe,ps){
  // alert("from inside pc");
  spe.searchBy ="all";
  spe.searchKey = "";
  spe.productList = [];

  updateAllProductList();

  spe.details = function(product){
    ps.prctMdl = product;
    ps.showDateRow = true;
    ps.showAButton = false;
    if(product.activeState.length == 4){
      // console.log("true");
      ps.showSQuantity = true;
    }else if(product.activeState.length == 5){
      // console.log("falsez");
      ps.showSQuantity = false;
    }

  }


  spe.updateProductListFromSearch = function(){
    if(spe.searchBy == "productName"){
      updateProductByName(spe.searchKey);
    }else if(spe.searchBy == "productNumber"){
      updateProductByNumber(spe.searchKey);
    }else if(spe.searchBy == "upc"){
      updateProductByUPC(spe.searchKey);
    }else if(spe.searchBy == "id"){
      updateProductById(spe.searchKey);
    }else{
      updateAllProductList();
    }
  }
  function updateAllProductList(){
    ps.getAllProduct().then(function(data){
      spe.productList = data.products;
    });
  }

  function updateProductByName(name){
    ps.getProductByName(name).then(function(data){
      spe.productList = data.products;
    });
  }

  function updateProductById(id){
    ps.getProductById(id).then(function(data){
      spe.productList = [];
      spe.productList.push(data);
    });
  }

  function updateProductByUPC(upc){
    ps.getProductByUPC(upc).then(function(data){
      spe.productList = data.products;
    });
  }

  function updateProductByNumber(number){
    ps.getProductByNumber(number).then(function(data){
      spe.productList = data.products;
    });
  }


}]);
