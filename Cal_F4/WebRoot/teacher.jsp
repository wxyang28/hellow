<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>

<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body  background="img/bg_ex.png"  style="background-repeat:no-repeat; background-position:1080px  200px; background-color:#FFFACD;">
	<%
		String id = (String) session.getAttribute("idCard");
		if (null == id || id.equals("")) 
		{
			out.print("<script language='javascript'>alert('请先登录系统！');window.location = 'login.jsp';</script>");
		}
	%>
	<%
		String teaName = session.getAttribute("usernameView").toString();
		session.setAttribute("teaName", teaName);
	%>
	<div align="center">
		<p style="color:pink;font-size:50px;">欢迎您,亲爱的老师!</p>
		<p align="right">
			<a href="invalide.jsp" target="top">退出登录</a>
		</p>
	</div>
	<div align="center">
		<br> <br> <a href="StuGrade.jsp">查看学生成绩信息</a> <br> <br>
		<a href="Stu_info.jsp">查看学生信息</a> <br> <br> <a
			href="upload.jsp">出题</a>
	</div>
	<div align="center">
		<form action=""></form>
	</div>
</body>
</html>
