<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ page import="com.lgs.bean.Ex"%>
<%@ page import="com.lgs.dao.Dao"%>
<%@ page import="javax.swing.JOptionPane"%>
<%
	Vector ti = (Vector) session.getAttribute("timu");
%>
<html>
<head>
<title>student!</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body background="img/xiong01.jpg">
	<div>
	<%
		String id = (String) session.getAttribute("idCard");
		if (null == id || id.equals("")) {
			out.print("<script language='javascript'>alert('请先登录系统！');window.location = 'login.jsp';</script>");
		}
	%>
		<%
			//答题结束后
			String judge = session.getAttribute("judgefinish").toString();
			if (judge.equals("session")) {
			    session.invalidate();
				//JOptionPane.showMessageDialog(null, "答题结束！");
				out.print("<script>alert('答题结束！');</script>");
			}
		%>
		<p align="right">
			<a href="invalide.jsp" target="top">退出登录</a>
		</p>
		<form name="sDegree" method="post" action="SelectExercise">
			<tr><%=request.getSession().getAttribute("usernameView")
					.toString()%>
				请选择要进行的练习:
			</tr>
			<input type="hidden" id="user"
				value="<%=request.getSession().getAttribute("usernameView")
					.toString()%>">
			<%
				//定义用户名
				String usernameView = request.getSession()
						.getAttribute("usernameView").toString();
				session.setAttribute("usernameGrade", usernameView);
				session.setAttribute("time01", System.currentTimeMillis());
			%>
			<br>
			<tr>
				<select name="select">
					<option value="simple">简单四则运算</option>
					<option value="hard">混合四则运算</option>
					<option value="properfraction">真分数运算</option>
				</select>
			</tr>
			<tr>
				<input type="submit" value="提交" />
				<input type="hidden" value="<%=usernameView%>" name="username" />
			</tr>
		</form>
	</div>
	<div>
		<p align="right">
			<a href="SSGrade.jsp">查看成绩</a>
		</p>
		<p align="right">
			<a href="ListFileServlet">下载练习</a>
		</p>
		<p align="right">交流互动</p>
		<img src="img/teacher.jpg" align="right" />
	</div>
</body>
</html>
