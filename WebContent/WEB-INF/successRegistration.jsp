<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful Registration.</title>
</head>
<body>

	<%@include file="header.jsp"%>
	<center>
		<h1>Registration Successful</h1>
	</center>

	<br>
	<br>
	<br>
	<br>
	<form:form method="GET" action="/ClothingCloset/login/loginPage">
		<center>
			<p>You can Login Here.</p>
			<input type="submit" value="Login" />
		</center>
	</form:form>

</body>
</html>