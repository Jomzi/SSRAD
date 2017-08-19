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
	<h1>Add New Customer</h1>
	<form:form modelAttribute="customer" method="post">
		<table>
			<tr>
				<td>Cust Name:</td>
				<td><form:input path="cName"></form:input><form:errors path="cName"></form:errors></td>
				<td><c:if test="${not empty error}">${error}</c:if></td>
			</tr>
			<tr>
				<td><button type="submit">Add</button></td>
			</tr>
		</table>
	</form:form>
	
	<a href="/">Home</a>
	<a href="/addBook">Add Book</a>
	<a href="/addCustomer">Add Customers</a>
	<a href="/newLoan">New Loans</a>
</body>
</html>