<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Repeat Final Project</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty error}">
			<h1>Could not delete Loan</h1>
			<h2>${error}</h2>
		</c:when>
		<c:otherwise>
			<h1>Delete Loan</h1>
			<form:form modelAttribute="loan" method="post">
				<table>
					<tr>
						<td>Loan ID:</td>
						<td><form:input path="lid"></form:input><form:errors path="lid"></form:errors></td>
					</tr>
					<tr>
						<td><button type="submit">Delete</button></td>
					</tr>
				</table>
			</form:form>
		</c:otherwise>
	</c:choose>
	
	<a href="/">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/newLoan">New Loan</a>
</body>
</html>