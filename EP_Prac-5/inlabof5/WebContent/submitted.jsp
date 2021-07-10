<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.inlabof5.dao.LoginDao" %>
<%@ page import="com.inlabof5.dao.SubmitfeedbackDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>

<%
response.setHeader("Cache-Control", "no-store, max-age=0");
if(session.getAttribute("useremail") == null) {
	response.sendRedirect("index.html");
}
%>
<h1>
Welcome
<%
if(session.getAttribute("useremail") != null) {
String useremail = session.getAttribute("useremail").toString();
LoginDao logindao = new LoginDao();
out.print(logindao.getUserfirstname(useremail));
}
%>
</h1>
<br>
<h2>You have already submitted your response</h2>
<br>
<h2>Your previous response is </h2>
<%
if(session.getAttribute("useremail") != null) {
String useremail = session.getAttribute("useremail").toString();
SubmitfeedbackDao feedbackdao = new SubmitfeedbackDao();
out.print(feedbackdao.getfeedback(useremail));
}
%>
<br>
<br>
<p>To update your feedback please submit it in the box below</p>
<form action="submitfeedback" method="get">
<textarea rows="10" cols="50" name="feedback" id="feedback"></textarea>
<br><br>
<input type="submit" value="Submit">
</form>
<br>
<br>
<a href="LogoutServlet">Logout</a>
</body>
</html>