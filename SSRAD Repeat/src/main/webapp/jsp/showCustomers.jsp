<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SS RAD Repeat Final Project</title>
	<link href="../style.css" rel="stylesheet">
</head>
<body>
	<h1>List of Customers</h1>
	<c:forEach items="${customers}" var="customer">
		<h2>${customer.cId}</h2>
		<h2>${customer.cName}</h2>
		<h3>${customer.cName}'s Loans</h3>
		<table>
			<tr>
				<td>Load ID</td>
				<td>Book ID</td>
				<td>Title</td>
				<td>Author</td>
			</tr>
			<c:forEach items="${customer.loans}" var="loans">
			<tr>
				<td>${loans.lid}</td>
				<td>${loans.book.bid}</td>
				<td>${loans.book.title}</td>
				<td>${loans.book.author}</td>
			</tr>
			</c:forEach>
		</table>
	</c:forEach>
	
	<a href="/">Home</a>
	<a href="/addBook">Add Book</a>
	<a href="/showBooks">List Books</a>
	<a href="/showLoans">List Loans</a>
	<a href="/logout">Logout</a>
</body>
</html>