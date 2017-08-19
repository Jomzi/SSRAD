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
		<c:when test="${not empty noSuchCust || not empty noSuchBook || not empty bookOnLoan}">
			<h1>Could not create new Loan</h1>
			<h2>${noSuchCust} ${noSuchBook} ${bookOnLoan}</h2>
		</c:when>
		<c:otherwise>
			<h1>New Loan</h1>
			<form:form modelAttribute="loan" method="post">
				<table>
					<tr>
						<td>Customer ID:</td>
						<td><form:input path="cust.cId"></form:input><form:errors path="cust.cId"></form:errors></td>
					</tr>
					<tr>
						<td>Book ID:</td>
						<td><form:input path="book.bid"></form:input><form:errors path="book.bid"></form:errors></td>
					</tr>
					<tr>
						<td><button type="submit">Loan Book!</button></td>
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