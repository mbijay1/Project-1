"use strict";

// alert("service linked");

angular.module("productApp").service("productService",function($http){
//  alert("service called");
  this.prctMdl = {activeDate:"",
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
  this.showAButton = true;
  this.showDateRow = false;
  this.showSQuantity = false;


   this.getEnumCategory = function(){
    return $http({
      method:"get",
      url:"http://localhost:9999/project-cubic/product/enumCategory"
    }).then(function(result){
      return result.data;
    });
  }

  this.getEnumManufacture = function(){
    return $http({
      method:"get",
      url:"http://localhost:9999/project-cubic/product/enumManufacture"
    }).then(function(result){
      return result.data;
    });
  }



  this.getAllProduct = function(){
    return $http({
      method:"get",
      url:"http://localhost:9999/project-cubic/product/all"
    }).then(function(result){
      return result.data;
    });
  }

  this.getProductByName = function(name){
    return $http({
      method:"get",
      url:"http://localhost:9999/project-cubic/product/name?name="+name
    }).then(function(result){
      return result.data;
    });
  }

  this.getProductById = function(id){
    return $http({
      method:"get",
      url:"http://localhost:9999/project-cubic/product/"+id
    }).then(function(result){
      return result.data;
    });
  }

  this.getProductByUPC = function(upc){
    return $http({
      method:"get",
      url:"http://localhost:9999/project-cubic/product/upc?upc="+upc
    }).then(function(result){
      return result.data;
    });
  }

  this.getProductByNumber = function(number){
    return $http({
      method:"get",
      url:"http://localhost:9999/project-cubic/product/number?number="+number
    }).then(function(result){
      return result.data;
    });
  }

  this.postProduct = function(productData){
    console.log("post called");
    return $http({
      method:"post",
      url:"http://localhost:9999/project-cubic/product",
     data:productData
   }).then(function(result){
      alert("Product Sucessfully Added");
      return result.data;

    }).catch(function(err){
      return err.data;
    });
  }

  this.putProduct = function(productData){
    return $http({
      method:"put",
      url:"http://localhost:9999/project-cubic/product",
     data:productData
    }).then(function(result){
      alert("Product Sucessfully Updated");
      return result.data;
    }).catch(function(err){
      // alert("err");
      // console.log(err);
      return err.data;
    });
  }
  this.deleteProduct = function(productPk){
    return $http({
      method:"delete",
      url:"http://localhost:9999/project-cubic/product/"+productPk,
    }).then(function(result){
      return result.status;
    });
  }
});
