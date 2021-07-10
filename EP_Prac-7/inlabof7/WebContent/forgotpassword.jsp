<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot password</title>
</head>
<body>
<%
String uv = request.getParameter("email");
Cookie ck=new Cookie("uname",uv);
response.addCookie(ck);
%>
<h1>Looks like you have entered a wrong password</h1>
<p>Use the link below to reset your password</p>
<a href="./resetpassword.jsp">Reset password</a>
</body>
</html>