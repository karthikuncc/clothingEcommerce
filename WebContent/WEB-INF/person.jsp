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

<section class="form-style-5">
<h2>Register Your Account</h2>
<form:form method="POST" action="/ClothingCloset/login/registration">
   
    
        
        <form:input path="firstName" required="true" placeholder="First Name"/>
    
        
        <form:input path="lastName" required="true"placeholder="Last Name"/>
    
    
          
        <form:select path="gender">
        	<form:option value="Male"></form:option>
        	<form:option value="Female"></form:option> 
        </form:select>
        <%-- <td><form:input path="gender" /></td> --%>
   
        
        <form:input path="mobileNumber" required="true" placeholder="Mobile Number"/>
    
        
        <form:input path="street" required="true" placeholder="Street"/>
   

		<form:input path="city" required="true" placeholder="City"/>
   
    
        
        <form:input path="state" required="true" placeholder="State"/>
    
        
        <form:input path="pincode" required="true" placeholder="Pin code"/>
    
   
        
        <form:input path="email" required="true" placeholder="Enter Your Email ID"/>
   
   
        
        <form:password path="password" required="true" placeholder="Password"/>
   

        
    
        <form:label path="subscription"> Subscribe </form:label>
        <form:select path="subscription">
        	<form:option value="Y"></form:option>
        	<form:option value="N"></form:option> 
        </form:select>
        <%-- <td><form:input path="gender" /></td> --%>
    
    
        
     
          <form:label path="subscriptionType"> Subscription</form:label>
        	<form:select path="subscriptionType">
        	<form:option value="Daily"></form:option>
        	<form:option value="Weekly"></form:option> 
        	<form:option value="Monthly"></form:option> 
        </form:select>
        <%-- <td><form:input path="gender" /></td> --%>
    
          <form:label path="role"> Role </form:label>
        <form:select path="role">
        	<form:option value="Alumni"></form:option>
        	<form:option value="Faculty"></form:option> 
        	<form:option value="Student"></form:option> 
        </form:select>
        <%-- <td><form:input path="gender" /></td> --%>
  
    

    
  
            <input type="submit" value="Register"/>
     
 
</form:form>
</section>
</body>
</html>