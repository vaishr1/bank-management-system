<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
  <html>
  <head>
  <title>Registration Page</title>
  <style>
  

h1{
color:#0000ff;
font-family: cursive;
}



  </style>
  </head>
 <body>
  <h1><center>Apply Home Loan</center></h1>
  <form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/applyHomeLoan" modelAttribute="applyHomeLoan">
  <table>
   
      <tr>
          <td>Loan Amount :</td>
          <td><form:input path="loanAmount" /></td>
          <td><form:errors path="loanAmount" cssClass="error" /></td>
      </tr>
      <tr>
      <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
          <td>Loan Apply Date  :</td>
        
          <td><form:input path="loanApplyDate"  value="<%= df.format(new java.util.Date())%>" type="hidden" /><%= df.format(new java.util.Date())%></td>
          <td><form:errors path="loanApplyDate" cssClass="error" /></td>
      </tr>
      <tr>
          <td class="select">Duration of the loan(in years)  :</td>
           <td> <form:select  path="loanDuration"> 
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="20">20</option>
                </form:select>
       </td>
        
          
          <td><form:errors path="loanDuration" cssClass="error" /></td>
      </tr>
      <tr>
          <td>Annual Income   :</td>
          <td><form:input path="annualIncome" /></td>
          <td><form:errors path="annualIncome" cssClass="error" /></td>
      </tr>
      <tr>
          <td>Company Name   :</td>
          <td><form:input path="companyName" /></td>
          <td><form:errors path="companyName" cssClass="error" /></td>
      </tr>
      <tr>
          <td>Designation   :</td>
          <td><form:input path="designation" /></td>
          <td><form:errors path="designation" cssClass="error" /></td>
      </tr>
      <tr>
          <td>Total Experience   :</td>
          <td><form:input path="totalExperience" /></td>
          <td><form:errors path="totalExperience" cssClass="error" /></td>
      </tr>
      <tr>
          <td>Experience with Current company  :</td>
          <td><form:input path="currentExperience" /></td>
          <td><form:errors path="currentExperience" cssClass="error" /></td>
      </tr>
      <tr>
          <td colspan="2"><center><input type="submit" value="Submit"></center></td>
      </tr>
  </table>
  </form:form>
  
  </body>
  </html> 