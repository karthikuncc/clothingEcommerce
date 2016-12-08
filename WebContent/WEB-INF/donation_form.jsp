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

<link href='http://fonts.googleapis.com/css?family=Bitter'
	rel='stylesheet'>
</head>

<style>

#myid
{
  font-family: Georgia, "Times New Roman", Times, serif; 
  font-size: 150%;
  margin: 05px auto;
  float:left;
  margin-top: 20px;
  margin-left: 25px;
}

body
{
    
    background-image: url("http://wallpapercave.com/wp/o5kkKdN.jpg");
}
.form-style-5{
    max-width: 500px;
    padding: 10px 20px;
    background: #f4f7f8;
    margin: 10px auto;
    padding: 20px;
    background: #f4f7f8;
    border-radius: 8px;
    font-family: Georgia, "Times New Roman", Times, serif;
}
.form-style-5 fieldset{
    border: none;
}
.form-style-5 legend {
    font-size: 1.4em;
    margin-bottom: 10px;
}
.form-style-5 label {
    display: block;
    margin-bottom: 8px;
}
.form-style-5 input[type="text"],
.form-style-5 input[type="password"],
.form-style-5 input[type="date"],
.form-style-5 input[type="datetime"],
.form-style-5 input[type="email"],
.form-style-5 input[type="number"],
.form-style-5 input[type="search"],
.form-style-5 input[type="time"],
.form-style-5 input[type="url"],

.form-style-5 textarea,
.form-style-5 p,
.form-style-5 a,
.form-style-5 table,
.form-style-5 select {
    font-family: Georgia, "Times New Roman", Times, serif;
    background: rgba(255,255,255,.1);
    border: none;
    border-radius: 4px;
    font-size: 16px;
    margin: 0;
    outline: 0;
    padding: 7px;
    width: 100%;
    box-sizing: border-box; 
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box; 
    background-color: #e8eeef;
    color:#8a97a0;
    -webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    margin-bottom: 30px;
    
}
.form-style-5 input[type="text"]:focus,
.form-style-5 input[type="password"]:focus,
.form-style-5 input[type="date"]:focus,
.form-style-5 input[type="datetime"]:focus,
.form-style-5 input[type="email"]:focus,
.form-style-5 input[type="number"]:focus,
.form-style-5 input[type="search"]:focus,
.form-style-5 input[type="time"]:focus,
.form-style-5 input[type="url"]:focus,
.form-style-5 textarea:focus,
.form-style-5 p:focus,
.form-style-5 a:focus,
.form-style-5 select:focus{
    background: #d2d9dd;
}
.form-style-5 select{
    -webkit-appearance: menulist-button;
    height:35px;
}
.form-style-5 .number {
    background: #1abc9c;
    color: #fff;
    height: 80px;
    width: 80px;
    display: inline-block;
    font-size: 0.8em;
    margin-right: 4px;
    line-height: 30px;
    text-align: center;
    text-shadow: 0 1px 0 rgba(255,255,255,0.2);
    border-radius: 15px 15px 15px 0px;
}

.form-style-5 input[type="submit"],
.form-style-5 input[type="reset"],
.form-style-5 input[type="button"]
{
    position: relative;
    float:left;
    display: block;
    padding: 19px 39px 18px 39px;
    color: #FFF;
    margin: 0 auto;
    background: #1abc9c;
    font-size: 18px;
    text-align: center;
    font-style: normal;
    width: 50%;
    border: 1px solid #16a085;
    border-width: 1px 1px 3px;
    margin-bottom: 10px;
}
.form-style-5 input[type="submit"]:hover,
.form-style-5 input[type="reset"]:hover,
.form-style-5 input[type="button"]:hover
{
    background: #109177;
}

</style>

<body>
<%@include file="header.jsp"%>

	<br>
	<br>
	
	<center>
		<h1 id="myid">
			Clothing Closet <br>
			<br> <img
				src="http://www.whiteriveranimalrescue.org/donation2.jpg"
				alt="no image" width="200" height="200" />
		</h1>
		<br>
	</center>
	
	<section class="form-style-5">
	<form:form method="POST" action="/ClothingCloset/donate/donateItem">
  
   <%--  <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" required="true" /></td>
    </tr> --%>
   <%--  <tr>
        <td><form:label path="dateOfDonation">Date of Donation</form:label></td>
        <td><form:input path="dateOfDonation" required="true"/></td>
    </tr> --%>
   
        <form:label path="itemName">Item Name</form:label>
        <form:select path="itemName" placeholder="Item Name">
        	<form:option value="Belt"></form:option>
        	<form:option value="Sunglasses"></form:option>
        	<form:option value="Shoe"></form:option>
        	<form:option value="Caps"></form:option>
        	<form:option value="Wallets"></form:option>
        	<form:option value="T-Shirts"></form:option>
        	<form:option value="Formal Shirts"></form:option>
        	<form:option value="Sweat Shirts"></form:option>
        	<form:option value="Hoods"></form:option>
        	<form:option value="Blazers"></form:option>
        	<form:option value="Swim wears"></form:option>
        	<form:option value="Jeans"></form:option>
        	<form:option value="Shorts"></form:option>
        	<form:option value="Track Pants"></form:option>
        	<form:option value="Jeggings"></form:option>
        	<form:option value="Shrugs"></form:option>
        	<form:option value="Kurtas"></form:option>
        	<form:option value="Sarees"></form:option>
        	<form:option value="Dress Materials"></form:option>
        	<form:option value="Shawls"></form:option>  
        </form:select>
        <%-- <td><form:input path="gender" /></td> --%>
    <form:label path="size">Size</form:label>
       <form:select path="size" placeholder="SIZE">
        	<form:option value="S"></form:option>
        	<form:option value="M"></form:option>
        	<form:option value="L"></form:option>
        	<form:option value="XL"></form:option>	
        	</form:select>
       
        <form:input path="quantity" required="true" placeholder="Qunatity*"/>
    
        <form:input path="color" required="true" placeholder="color"/>

        <form:select path="item_Condition" placeholder="state">
        	<form:option value="Good"></form:option>
        	<form:option value="Excellent"></form:option>
        	<form:option value="Average"></form:option>
        	</form:select>
   
        <form:input path="description" placeholder="Description" />
    
          <form:label path="gender">Gender</form:label>
        <form:select path="gender">
        	<form:option value="Male"></form:option>
        	<form:option value="Female"></form:option> 
        </form:select>
       
	
	
        <form:label path="brand" >Brand</form:label>
        <form:input path="brand" required="true" placeholder="Brand *"/>
    

    
    

    
    
            <input type="submit" value="Donate"/>
            <input type ="reset" value = "Reset" />
       
    
 
</form:form>
  </section>
</body>
</html>