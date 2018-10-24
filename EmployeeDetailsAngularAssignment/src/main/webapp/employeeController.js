var app = angular.module("myApp", [ "ngRoute" ]);

app.config(function($routeProvider) {
	console.log("routing");
	$routeProvider.when("/home", {
		templateUrl : "home.html"
	}).when("/aboutUs", {
		templateUrl : "aboutUs.html"
	}).when("/contact", {
		templateUrl : "contact.html"
	});
}); 

/*app.config(['$routeProvider',function($routeProvider) {
	console.log("routing");
	$routeProvider.when("/home", {
		templateUrl : "home.html"
	}).when("/aboutUs", {
		templateUrl : "aboutUs.html"
	}).when("/contact", {
		templateUrl : "contact.html"
	});
}]);*/

/*app.config(['$routeProvider',
            function($routeProvider) {
              $routeProvider
                .when('/home', { templateUrl: 'temp/home.html',
              })
                .when('/about', { templateUrl: 'temp/aboutUs.html',
              })
                .when('/contact', { templateUrl: 'temp/contact.html',
              })                       
          }]);*/

app.filter('genderFilter', [function () {
    return function (employee) {
       if (employee.gender== "M") {
          return   "Mr."+employee.employeeName;
        }
        else {
           return  "Mrs."+employee.employeeName;
        }   

    };
}]);


app.controller('employeeController', function($scope, $http) {
//	$scope.editing = false;
	  $http.get("http://localhost:8083/employeeDetails").then(function (response) {
	      $scope.myHttpData = response.data;
	      
	      console.log("mydata  "+$scope.myHttpData);
	  });
	  
	  
	  
	  $scope.deleteData = function(employeeId) {
		  console.log(employeeId);
		  $http.delete("http://localhost:8083/deleteData/"+employeeId).then(
                  function(result) {
                      console.log("delete 1");
                      $http.get('http://localhost:8083/employeeDetails').then(
                                    function(response) {
                                           $scope.myHttpData = response.data;
                                        //   alert("User has deleted Successfully")
                                    });
               }
                  );

	        console.log("deleted data");
	    };
	    
	    /*$scope.deleteData = function(eId){

	    	  $http.delete("http://localhost:8083/deleteData/" + eId).then(
	    	    function(result) {
	    	           var i;
	    	           // result is the item you changed
	    	           $http.get("http://localhost:8083/employeeDetails").then(
	    	                         function(response) {
	    	                        	 $scope.myHttpData = response.data;
	    	                            
	    	                         });
	    	    });
	    }*/
	    
	   $scope.saveData = function(data) {
		   console.log(data.task);
		   var jsonData = {
				   employeeId:data.employeeId,
				   gender: data.gender,
				   employeeName: data.employeeName,
				   task: data.task,
				   assignedBy: data.assignedBy,
				   status: data.status
		   };
	       $http.put("http://localhost:8083/updateData",jsonData);
	        console.log("in edit app key "+data.employeeName);
	    };
	   
	});

app.controller("editDataController",function($scope){
	console.log("hello");
	});

