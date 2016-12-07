<!-- Project name: ClothingCloset Author: Chaitanya -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> LOGIN SUCCESSFUL</h1>
			<div class="central">
		<table width=100% height=100% border="2">

			<tr>
				<form:form method="GET"
					action="/ClothingCloset/donate/donate">
					<td width=35% valign="middle" align="center">
						<h3>Click here for the User to login:</h3> <br> <br> 
					<input type="image" src="user.jpg" width=50 height=50 />
					</td>

				</form:form>
					<form:form method="GET"
					action="/ClothingCloset/login/pblStaffLogin">
				<td width=35% valign="middle" align="center">
					<h3>Click Here for Staff or Admin to login:</h3> <br> <br>
					 
						
					<input type="image" src="images/admin.png" width=50 height=50 />
				</td>
				</form:form>
			</tr>
		</table>
	</div>
		
		
</body>
</html>