<%-- 
    Document   : inside_categories
    Created on : Nov 5, 2016, 10:36:35 AM
    Author     : deepika
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories Page</title>
<link rel="stylesheet" href="styles/home_categories_css.css"
	type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Bitter'
	rel='stylesheet'>
</head>
<body>

	<%@include file="header.jsp"%>

	<br>
	<br>

	<br>
	<!--  <h1>Retrieve content from server!</h1> -->
	<br>
	<br>
	<br>
	<br>
	<br>
	
<%-- 	<c:if
		test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>

	</c:if>
	 --%>
	 
	
	 
	 
	<br>
	<br>
	<br>
	<br>
	<br>
	<section class="form-style-5"> 

	<%-- <form:form action=""> --%>
		
<table border = 1px align="center">
  <c:forEach items="${lists}" var="listValue">
    <tr>
    <form:form method="post" action = "" commandName="user">
    
     <%--  <form:checkbox  path="item" value=" <c:out value="${listValue.itemId}" />"/> --%>
     <%-- <td> <form:checkbox path="item" value = "${listValue.itemId}" /> --%>
   <%--   <td><c:out value="${listValue.itemId}" /> </td>  --%>
      <td><c:out value="${listValue.itemName}" /></td>
      <td><c:out value="${listValue.price}" /></td>
      <td><c:out value="${listValue.color}" /></td>
      <td><c:out value="${listValue.itemCondition}" /></td>
    </tr>
    
    <input type="submit" value="Proceed to Payment">
		&nbsp;&nbsp;&nbsp;&nbsp; <span>Total Amount : $ </span>
	</form:form>
    
  </c:forEach>
</table>

<%-- <input type="submit" value="Proceed to Payment">
		&nbsp;&nbsp;&nbsp;&nbsp; <span>Total Amount : $ </span>

	</form:form> --%>
	</section>
</body>
</html>
