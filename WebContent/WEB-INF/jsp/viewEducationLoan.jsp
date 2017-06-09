<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Insert title here</title>
</head>

<body ng-app="myApp">
<style>
body {background-color:gray;}
h1   {color: black;}
p    {color: red;}
a    {color: black}
</style>

<h1><center>Education Loan Details</center></h1>
       <!-- Please add your application links by replacing the below sample links -->
       <br>
      <h3>Your Account number is ${AccountNumber}</h3>
    <div ng-controller="EmpCtrl">
       
      <input type="text" ng-model="search.$" placeholder="Search By All"/>
       <hr/>
       <table>
<table>
<tr>
<th>S.No.</th>
<th>Education Loan Account Number</th>
<th>Course Fee</th>
<th>Course Name</th>
<th>Education Loan Amount</th>
<th>Education Loan Duration</th>
<th>Father Annual Income</th>
<th>Education Loan Id</th>
<th>Father Name</th>
<th>Id Card Number</th>
<th>Loan Apply Date</th>
<!-- <th>Account Number</th> -->
</tr>

            <tr ng-repeat="detail in eduLoanDetails | filter: search">
               <td><center>{{$index + 1}}</td>
                <td><center>{{detail.eduLoanAccountNumber}}</center></td>
                <td><center>{{detail.courseFee}}</center></td>
                <td><center>{{detail.courseName}}</center></td>
                <td><center>{{detail.eduLoanAmount}}</center></td>
                <td><center>{{detail.eduLoanDuration}}</center></td>
               <td><center>{{detail.fatherAnnualIncome}}</center></td>
                  <td><center>{{detail.educationLoanId}}</center></td>
                   <td><center>{{detail.fatherName}}</center></td>
                   <td><center>{{detail.idCardNumber}}</center></td>
                   <td><center>{{detail.loanApplydate}}</center></td>
                  <!--  <td>{{detail.account_Number}}</td> -->
                 
                    
            </tr>
        
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'http://localhost:8086/BaseCodeSlice_BankManagementSystem/mvc/viewEducationLoan1?AccountNumber=${AccountNumber}'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.eduLoanDetails = data;
            })
        
           
        })
    </script>
</body>
</html>

















  
  
  
  
  