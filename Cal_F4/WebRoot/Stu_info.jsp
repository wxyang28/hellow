<%@ page language="java" import="java.util.*" import="com.lgs.bean.User"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.lgs.dao.Dao"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body background="img/bg_ssg.png" style="background-repeat:no-repeat; background-position:1080px  200px; background-color:#FFFACD;">
	<div>
		<p align="right">
			<a href="teacher.jsp">返回</a>
		</p>
		<%=session.getAttribute("teaName").toString()%>
		欢迎您！<br>
		<br>
		<br>
		<p align="center">您的学生信息如下</p>
	</div>
	<div align=center>
		<%
			String username = session.getAttribute("teaName").toString();
			Dao dao = new Dao();
			Vector allUsers = dao.getAllUsers();
		%>
		<table width=680>
			<tr bgcolor=#cccccc height=18>
				<td width=50 align=center>用户名</td>
				<td width=250 align=center>真实姓名</td>
			</tr>

			<%
				for (int i = 0; i < allUsers.size(); i++) {
					User user = (User) allUsers.get(i);
			%>
			<tr>
				<td align=center><%=user.getUsername()%></td>
				<td><%=user.getRealname()%></td>

			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>
