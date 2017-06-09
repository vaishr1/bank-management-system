<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myApp">

	<div ng-controller="EmpCtrl">

		<h2 align="center">Welcome</h2>
		<h3>
<h1>Successful!!! <br>Loan Account Number is: ${msg}</h1>
			<hr />
			<table>
			<tr >
					<th>S.NO</th>
					<th>Account Number</th>
					<th>Account Type</th>
					<th>Account Holder Name</th>
					<th>Account Balance</th>

				</tr>
				<tr ng-repeat="user in List | filter: search">
					<td>{{$index + 1}}</td>
					<td>{{user.accountNumber}}</td>
					<td>{{user.accountType}}</td>
					<td>{{user.accountHolderName}}</td>
					<td>{{user.accountBalance}}</td>

				</tr>
			</table>

		</h3>
	</div>
	
		<table class="table">
			<tr>
				<td><button>
						<a
							href="http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/PerformTransaction?AccountNumber=${msg}">Perform
							Transaction</a>
					</button></td>
			
					<td>
				<button>
						<a
							href="http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/viewTransaction?AccountNumber=${msg}">View
							Transaction</a>
					</button></td></tr>
			<tr>
				<td><button>
						<a
							href="http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/insertEducationLoan?AccountNumber=${msg}">Apply
							Education Loan</a>
					</button></td>
				<td><button>
						<a
							href="http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/viewEducationLoan?AccountNumber=${msg}">View
							Education Loan</a>
					</button></td>
			</tr>

			<tr>
				<td><button>
					<a
						href="http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/applyHomeLoan?AccountNumber=${msg}">Apply
						Home Loan</a>
				</button></td>
				<td><button>
					<a
						href="http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/viewHomeLoan?AccountNumber=${msg}">View
						Home Loan</a>
				</button></td>
			</tr>
		</table>
	

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'http://localhost:9090/BaseCodeSlice_BankManagementSystem/mvc/homepage?AccountNumber=${msg}'
            	  
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
           $scope.List = data;
            })
         })
    </script>

</body>
</html>