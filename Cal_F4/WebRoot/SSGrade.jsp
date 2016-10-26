<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ page import="com.lgs.bean.grade" import="com.lgs.dao.Dao"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body bgcolor="#FFF0F5" background="img/bg_ssg.png" style="background-repeat:no-repeat; background-position:1080px  200px;">
	<div>
		<p align=right>
			<a href="student.jsp" style="color:#000000;position:absolute; top: 20px; right:20px;">返回</a>
		</p>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div align=center>
		<%
			String username=session.getAttribute("usernameGrade").toString();
			Dao dao = new Dao();
			Vector allGrades = new Vector();
			allGrades = dao.getAllGrade(username);
		%>
		<table width=680>
			<tr bgcolor=#cccccc height=18>
				<td width=50 align=center>姓名</td>
				<td width=250 align=center>成绩</td>
				<td width=50 align=center>用时</td>
			</tr>

			<%
				for (int i = 0; i < allGrades.size(); i++) {
					grade gra = (grade) allGrades.get(i);
			%>
			<tr>
				<td align=center><%=gra.getUsername()%></td>
				<td><%=gra.getScore()%></td>
				<td><%=gra.getTime()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>
