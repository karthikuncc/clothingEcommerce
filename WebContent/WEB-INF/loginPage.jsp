<!-- Project name: ClothingCloset Author: Chaitanya -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="css/style.css"/> -->
<title>Login</title>
</head>
<body>

	<%@include file="header.jsp"%>
	<!-- <div class="central"> -->
		<table width=100% height=100% align="center">

			<tr>
				<%-- <form:form method="GET" action="/ClothingCloset/login/userLogin"> --%>
					<td valign="middle" align="center">
						<h3>Click here for the User to login:</h3> <br> <br> 
						<a href="/ClothingCloset/login/userLogin">
							<img src="WEB-INF/user.jpg" />
						</a>
					<!-- <input type="image" src="user.jpg" width=50 height=50 /> -->
					</td>

	<%-- 			</form:form> --%>
	
	
					<%-- <form:form method="GET"
					action="/ClothingCloset/login/pblStaffLogin"> --%>
				<td  valign="middle" align="center">
					<h3>Click Here for Staff or Admin to login:</h3> 
					 <a href="/ClothingCloset/admin/pblStaffLogin">
							<img src="/user.jpg" />
						</a>
						<br> <br>
					<!-- <input type="image" src="images/admin.png" width=50 height=50 /> -->
				</td>
				<%-- </form:form> --%>
			</tr>
		</table>
<!-- 	</div> -->
</body>
</html>