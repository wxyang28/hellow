<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.lgs.dao.Dao" import="com.lgs.bean.grade"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body background="img/xiong06.jpg">
	<div>
		<p align="right">
			<a href="teacher.jsp">返回</a>
		</p>
		<%=session.getAttribute("teaName").toString()%>
		欢迎您！<br> <br> <br>
		<p align="center">您的学生信息如下</p>
	</div>
	<div align=center>
		<%
			//String username=session.getAttribute("teaName").toString();
			Dao dao = new Dao();
			Vector allGrades = new Vector();
			allGrades = dao.getUserGrades();
		%>
		<table width=680>
			<tr bgcolor=#cccccc height=18>
				<td width=50 align=center>用户名</td>
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
