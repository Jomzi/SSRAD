<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SS RAD Repeat Final Project</title>
	<link href="../style.css" rel="stylesheet"></head>
<body>
	<h1>List of Books</h1>
	<table>
		<tr>
			<th>Book ID</th>
			<th>Title</th>
			<th>Author</th>
		</tr>
		<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.bid}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
		</tr>
		</c:forEach>
	</table>
	
	<a href="/">Home</a>
	<a href="/addBook">Add Book</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/logout">Logout</a>
</body>
</html>