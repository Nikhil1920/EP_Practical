<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="labof6.Validateuser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<jsp:useBean id="checkuser" class="labof6.Checkuser"></jsp:useBean>
<jsp:setProperty property="*" name="checkuser"/>
<%  
boolean status=Validateuser.validate(checkuser);  
if(status){  
out.println("You are successfully logged in");  
session.setAttribute("session","TRUE");  
}  
else  
{  
out.print("Sorry, email or password error");  
%>  
<jsp:include page="index.html"></jsp:include>  
<%  
}  
%> 
</body>
</html>