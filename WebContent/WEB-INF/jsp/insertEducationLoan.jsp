<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Insert Education Loan</title>
<style>
	.cssClass {
		background-color: red;
	}
</style>
</head>
<body>
<h1><center>Apply Education Loan</center></h1>
<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/insertEducationLoan" modelAttribute="educationLoan">
<table>
    <%-- <tr>
        <td>Account Number </td>
        <td><form:input path="accountNumber" /></td>
        <td><form:errors path="accountNumber" cssClass="error" /></td>
    </tr> 
     --%>
    <tr>
        <td>Loan Amount </td>
        <td><form:input path="eduLoanAmount" /></td>
        <td><form:errors path="eduLoanAmount" cssClass="error" /></td>
    </tr>
    
     <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
        <tr>  <td>Loan Apply Date  :</td>
     <td><form:input path="loanApplydate"  value="<%= df.format(new java.util.Date())%>" type="hidden" /><%= df.format(new java.util.Date())%></td>
      <td><form:errors path="loanApplydate" cssClass="error" /></td>
     </tr>
    
   <td class="select">Duration of the loan(in years)  :</td>
     <td><form:select path="eduLoanDuration">
      <option value="5">5</option>
                <option value="10">10</option>
     </form:select>
     
        </td> 
   <%--  <tr>
        <td>Loan Apply Date </td>
        <td><form:input path="loanApplyDate" /></td>
        <td><form:errors path="loanApplyDate" cssClass="error" /></td>
    </tr>
     --%>
    <tr>
        <td>Course name </td>
        <td><form:input path="courseName" /></td>
        <td><form:errors path="courseName" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Course Fee</td>
        <td><form:input path="courseFee" /></td>
        <td><form:errors path="courseFee" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Father Name </td>
        <td><form:input path="fatherName" /></td>
        <td><form:errors path="fatherName" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>ID Number </td>
        <td><form:input path="idCardNumber" maxlength="16"/></td>
        <td><form:errors path="idCardNumber" cssClass="error" /></td>
    </tr>
     <tr>
        <td>Father's Annual Income </td>
        <td><form:input path="fatherAnnualIncome" /></td>
        <td><form:errors path="fatherAnnualIncome" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td colspan="2"><center><input type="submit" value="Submit"></center></td>
    </tr>
</table>
</form:form>

</body>
</html>