<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="labof6.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<%
session.setAttribute("userdetails", user);
%>
Account created Successfully with the following values<br>
<br>
<b>Name:</b><jsp:getProperty property="name" name="user"/><br>
<b>Email:</b><jsp:getProperty property="email" name="user" /><br>
<b>Password:</b><jsp:getProperty property="password" name="user"/><br>
</body>
</html>