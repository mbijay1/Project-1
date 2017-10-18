"use strict";
// alert("from outside aec");
angular.module("productApp").controller("addEditController", ["$scope","productService",function(spe,ps){
  // alert("from inside aec");
  spe.categoryList = [];
  spe.manufactureList = [];
  spe.productModel = {};
  spe.showAdd = ps.showAButton;
  spe.showDate = ps.showDateRow;
  spe.productModel = ps.prctMdl;

  spe.placeHolderName = "Enter Name";
  spe.placeHolderNumber = "Enter Number";
  spe.placeHolderUPC = "X-XXXXX-XXXXX-X";
  spe.nameClass = "";
  spe.numberClass = "";
  spe.upcClass = "";

  spe.showQuantity = ps.showSQuantity;

  spe.$watch(function(){
    return spe.productModel.activeState;
  },function(newVal, oldVal){

    if(newVal != oldVal){
      if(spe.productModel.activeState.length == 5){
        spe.showQuantity = false;
          // console.log("value false"+spe.showQuantity);
      }else if(spe.productModel.activeState.length == 4){
        spe.showQuantity = true;
          // console.log("value true"+spe.showQuantity);
      }
    }
  })

  spe.errorMessage = {};
  // initEmptyProductModel();

  spe.$watch(function(){
    return ps.showAButton;
  },function(newVal, oldVal){
    if(newVal != oldVal){
      spe.showAdd = ps.showAButton;
      console.log("print this line");
    }
  });

  spe.$watch(function(){
    return ps.showDateRow;
  },function(newVal, oldVal){
    if(newVal != oldVal){
      spe.showDate = ps.showDateRow;
    }
  });

  spe.$watch(function(){
    return ps.prctMdl;
  },function(newVal, oldVal){
    if(newVal != oldVal){
      spe.productModel = ps.prctMdl;
    }
  });

  ps.getEnumCategory().then(function(data){
    spe.categoryList = data.enumList;
    console.log(spe.categoryList);
  });

  ps.getEnumManufacture().then(function(data){
    spe.manufactureList = data.enumList;
    console.log(spe.manufactureList);
  })

  spe.addProduct = function(){
    if(nullValidation() == false && quantityValidation() == true && upcValidation()==true){
      ps.postProduct(angular.copy(spe.productModel)).then(function(data){
        //  alert("Sucessfully added");
        if(Object.keys(data).length == 2){
          //alert("error");
          spe.errorMessage = data;
        }
        else{
          //alert("sucess");
          spe.errorMessage={};
        }
      });
    }
  }

  spe.delProduct = function(){
    var deleteDecision = confirm("Are you sure?");
    if(deleteDecision){
      ps.deleteProduct(angular.copy(spe.productModel.pk));
    }
  }

  function nullValidation(){
    if(spe.productModel.productName.length != 0 &&
        spe.productModel.productNumber.length != 0 &&
        spe.productModel.upc.length != 0){
          return false;
        }
        else{
            if(spe.productModel.productName.length == 0){
                spe.placeHolderName = "!Name Required";
                spe.nameClass = "error";
            }

            if(spe.productModel.productNumber.length == 0){
                spe.placeHolderNumber = "!Number Required";
                spe.numberClass = "error";
            }

            if(spe.productModel.upc.length == 0){
                spe.placeHolderUPC = "!UPC Required";
                spe.upcClass = "error";
            }
            return true;
        }
  }

  function quantityValidation(){
    if(spe.productModel.activeState.length == 4){
      if(spe.productModel.currentQuantity.length == 0 || spe.productModel.currentQuantity == 0){
        spe.errorMessage = {errorCode : "101", errorDetails:"currentQuanity cannot be zero in active condition"};
        return false;
      }
      if(spe.productModel.thresholdQuantity.length == 0){
        spe.productModel.thresholdQuantity = 0;
      }

      if(spe.productModel.orderedQuantity.length == 0){
        spe.productModel.orderedQuantity = 0;
      }
      spe.errorMessage = {};
      return true;
    }
    spe.errorMessage = {};
    return true;
  }

  function upcValidation(){
    if(spe.productModel.upc.length == 15){
      spe.errorMessage = {};
      var splitedUPC = spe.productModel.upc.split("-");
      if(splitedUPC.length !=4){
        spe.errorMessage = {errorCode : "102", errorDetails:"Invalid UPC Format: Valid Format X-XXXXX-XXXXX-X"};
        return false;
      }
      if(splitedUPC[0] >= 0 && splitedUPC[0] <= 9 &&
        splitedUPC[1] >= 0 && splitedUPC[1] <= 99999 && splitedUPC[1].length == 5 &&
        splitedUPC[2] >= 0 && splitedUPC[2] <= 99999 && splitedUPC[2].length == 5 &&
        splitedUPC[3] >= 0 && splitedUPC[3] <= 9
      ){



        return true;
      }else{
        spe.errorMessage = {errorCode : "102", errorDetails:"Invalid UPC Format: Valid Format X-XXXXX-XXXXX-X"};
        return false;
      }
    }else{
      spe.errorMessage = {errorCode : "102", errorDetails:"Invalid UPC Format: Valid Format X-XXXXX-XXXXX-X"};
      return false;
    }
  }

  spe.updateProduct = function(){
      if(nullValidation() == false && quantityValidation() == true && upcValidation()==true){
        ps.putProduct(angular.copy(spe.productModel)).then(function(data){
          //  alert("Sucessfully added");
          if(Object.keys(data).length == 2){
            // alert("error");
            spe.errorMessage = data;
          }
          else{
            spe.errorMessage={};
          }
        });
      }
  }

    function initEmptyProductModel(){
      spe.productModel = {
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
        description:"",
        activeState:"false"
      }
    }
}]);
