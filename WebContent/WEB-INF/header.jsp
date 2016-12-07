<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Index page</title>
        <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
        <link rel="stylesheet" href="styles/signup_header.css" type="text/css"/>
    </head>
    
        <style>
            ul {    
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li input {
    float: right;
    position: absolute;
    display: block;
    text-align: right;
    padding: 14px 16px;
    text-decoration: none;
}

a:hover:not(.active) {
    background-color: #111;
}

.active {
background-color:#1abc9c;
}

.footer {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
        </style>
<body>
        
<ul>
  <li><a href="/ClothingCloset/itemdisplay/items">Home</a></li>
  <li><a href="/ClothingCloset/login/person">Register</a></li>
  <li><a href="/ClothingCloset/login/loginPage">Login</a></li>
  
</ul>
    </body>
</html>
