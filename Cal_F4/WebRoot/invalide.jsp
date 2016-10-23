<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<%
		session.invalidate();
		response.sendRedirect("login.jsp");
	%>
</body>
</html>
