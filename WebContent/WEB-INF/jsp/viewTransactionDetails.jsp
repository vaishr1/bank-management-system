<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Insert title here</title>
</head>
<body>
<style>
body {background-color:gray;}
h1   {color: black;}
p    {color: red;}
a    {color: black}
</style>
       <h1><center>Transaction Details</center></h1>
       <!-- Please add your application links by replacing the below sample links -->
       <br>
      
<center><body ng-app="myApp">
    <div ng-controller="EmpCtrl">
       
      <input type="text" ng-model="search.$" placeholder="Search"/>
       <hr/>
       
       <table>
       <tr>
<center><th>S.No.</th></center>
<center><th>Transaction ID</th></center>
<center><th>Transaction Description</th></center>
<center><th>Transaction Type</th></center>
<center><th>Transaction Amount</th></center>

</tr>
       
       
       
            <tr ng-repeat="detail in transactionDetailsList | filter: search">
                <td><center>{{$index + 1}}</center></td>
                <td><center>{{detail.transactionId}}</center></td>
                <td><center>{{detail.transactionDescription}}</center></td>
                <td><center>{{detail.transactionType}}</center></td>
                <td><center>{{detail.transactionAmount}}</center></td>
                
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/viewTransaction1?AccountNumber=${AccountNumber}'
            }).then(res=>res.data)
            .then(data => {
              console.log(data);
              $scope.transactionDetailsList = data;
            })
        
           
        })
    </script>
</body></center>
</html>

