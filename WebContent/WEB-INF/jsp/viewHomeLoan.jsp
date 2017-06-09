<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Insert title here</title>
</head>
<center><body>
	<h1>Home Loan Details</h1>
	<!-- Please add your application links by replacing the below sample links -->
	<br>
	
	
<body ng-app="myApp">
<style>
body {background-color:#A0A0A0;}

h1{
color:#0000ff;
font-family: cursive;
}


p    {color: red;}
a    {color: black}
</style>
    <div ng-controller="EmpCtrl">
       
      <input type="text" ng-model="search.$" placeholder="Search By All"/>
       <hr/>
       
       <table>
       <tr>
<th>S.No.</th>
<th>Loan Amount</th>
<th>Loan Duration</th>
<th>Loan Apply Date</th>
<th>Annual Income</th>
       </tr>
      

      
            <tr ng-repeat="detail in details | filter: search">
                <td><center>{{$index + 1}}</center></td>
                <td><center>{{detail.loanAmount}}</center></td>
                <td><center>{{detail.loanDuration}}</center></td>
                <td><center>{{detail.loanApplyDate}}</center></td>
                <td><center>{{detail.annualIncome}}</center></td>
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/viewHomeLoan1'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.details = data;
            })
        
           
        })
    </script>
</body></center>
</html>
















<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <html>
  <head>
  <title>Registration Page</title>
  <style>
  	.cssClass {
  		background-color: red;
  	}
  </style>
  </head>
  <body>
  
  <form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/viewHomeLoan" modelAttribute="viewHomeLoan">
  <table>
  <tr>
  <td>Loan Id :</td>
          <td><form:input path="homeloanId" /></td>
          <td><form:errors path="homeloanId" cssClass="error" /></td>
      </tr>
      
      <tr>
          <td>Loan Apply Date  :</td>
          <td><form:input path="loanAccountNumber" /></td>
          <td><form:errors path="loanAccountNumber" cssClass="error" /></td>
      </tr>
      
       <tr>
          <td colspan="2"><input type="submit" value="add"></td>
      </tr>
  
  
  </table>
  
  </form:form>
  
  </body>
  </html> --%>
  
  
  
  
  
  