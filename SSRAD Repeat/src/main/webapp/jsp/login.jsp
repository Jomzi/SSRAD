<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Repeat Final Project</title>
<style type="text/css"> 
	td.red {color : #ff0000};
</style>
</head>
<body>
	<h2>Login with Username and Password</h2>
	<form:form action="login" modelAttribute="user" method="post">
		<table>
			<tr>
				<td class="red"><c:if test="${not empty error}">${error}</c:if></td>
			</tr>
			<tr>
				<td>User:</td>
				<td><form:input path="username" name="username"></form:input><form:errors path="username"></form:errors></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" name="password"></form:input><form:errors path="password"></form:errors></td>
			</tr>
			<tr>
				<td><button type="submit">Login</button></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>
</body>
</html>