<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>下载文件显示页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body bgcolor=pink>
	<p align="right">
		<a href="student.jsp">返回</a>
	</p>
	<!-- 遍历Map集合 -->
	<c:forEach var="me" items="${fileNameMap}">
		<c:url value="DownloadServlet" var="downurl">
			<c:param name="filename" value="${me.key}"></c:param>
		</c:url>
${me.value}<a href="${downurl}">下载</a>
		<br />
	</c:forEach>
</body>
</html>
