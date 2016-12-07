<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Failure Registration.</title>
</head>
<body>

	<%@include file="header.jsp"%>
	<center>
		<h1>Registration Failed</h1>
	</center>

	<br>
	<br>
	<br>
	<br>
	<form:form method="GET" action="/ClothingCloset/itemdisplay/items">
		<center>
			<p>Please try again Later by going back to Home Page.</p>
			<input type="submit" value="Home" />
		</center>
	</form:form>

</body>
</html>