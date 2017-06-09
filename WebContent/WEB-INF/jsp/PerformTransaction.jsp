<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Registration Page</title>
</head>
<body>
 <h1><center>Perform Transactions</center></h1>
<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/PerformTransaction" modelAttribute="Transaction">
<table>

    <tr>
        <td>Transaction Description:</td>
        <td><form:input path="transactionDescription" /></td>
        <td><form:errors path="transactionDescription" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Transaction Type :</td>
       <td>   <form:select  path="transactionType">
						<option value="DEPOSIT">DEPOSIT</option>
						<option value="WITHDRAWAL">WITHDRAWAL</option>
						</form:select></td>  
       
        <td><form:errors path="transactionType" cssClass="error" /></td>
        
    </tr>
    <tr>
        <td>Transaction Amount :</td>
        <td><form:input  path="transactionAmount" /></td>
        <td><form:errors path="transactionAmount" cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="2"><center><input type="submit" value="Submit"></center></td>
    </tr>
</table>
</form:form>

</body>
</html>