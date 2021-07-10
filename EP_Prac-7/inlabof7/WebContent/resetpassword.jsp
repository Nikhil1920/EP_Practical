<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome User</h1>
<p>Your Email is <%Cookie ck[]=request.getCookies();
out.print(ck[0].getValue());
%></p>
<br>
<p>Please enter your new password below to change your password</p>
<form action="passwordchanged.html" method="post">
Password:<input type="password" name="password"/>
<input type="submit" value="change password"/>
</form>
</body>
</html>