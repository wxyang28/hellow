<!doctype html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.lgs.bean.Ex"%>
<%@ page import="com.lgs.dao.Dao"%>
<%@ page import="javax.swing.JOptionPane"%>
<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" href="stu_css/reset.css">
	<link rel="stylesheet" href="stu_css/style.css">
	<script src="js/modernizr.js"></script>
	<title>student！</title>
	<style>body{font-family: "microsoft yahei";}</style>
</head>
<body>
	<%
		String id = (String) session.getAttribute("idCard");
		if (null == id || id.equals("")) {
			out.print("<script language='javascript'>alert('请先登录系统！');window.location = 'login.jsp';</script>");
		}
	%>
	<main>
		<h1>欢迎进入四则运算系统</h1>
	</main>
	<a href="#cd-nav" class="cd-nav-trigger">Menu 
		<span class="cd-nav-icon"></span>

		<svg x="0px" y="0px" width="54px" height="54px" viewBox="0 0 54 54">
			<circle fill="transparent" stroke="#656e79" stroke-width="1" cx="27" cy="27" r="25" stroke-dasharray="157 157" stroke-dashoffset="157"></circle>
		</svg>
	</a>
	
	<div id="cd-nav" class="cd-nav">
		<div class="cd-navigation-wrapper">
			<div class="cd-half-block">
				<h2>导航</h2>

				<nav>
					<ul class="cd-primary-nav">
						<li><a href="#cd-nav" class="selected">首页</a></li>
						<li><a href="beforeTest.jsp">一般练习</a></li>
						<li><a href="ListFileServlet">下载作业</a></li>
						<li><a href="SSGrade.jsp">查看成绩</a></li>
						<li><a href="invalide.jsp" target="top">退出登陆</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="cd-half-block">
				<address>
					<ul class="cd-contact-info">
						<li>291076739@qq.com</a></li>
						<li>
							<span>天津大学</span>
							<span>北洋园校区</span>
						</li>
					</ul>
				</address>
			</div> 
		</div>
	</div>
<script src="js/jquery-2.1.1.js"></script>
<script src="js/main.js"></script>
</body>
</html>