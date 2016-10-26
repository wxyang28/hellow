<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>下载文件显示页面</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel='stylesheet' id='jquery-gif-css'  href='css/jquery.gif.css' type='text/css' media='all' />
<style>
	body{
		background: #495938;
		font-family: "microsoft yahei"
	}
</style>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body bgcolor=pink>
<div class="htmleaf-content" style="text-align: center;">
<p align="right">
	<a href="student.jsp" style="color: #FFFFFF;">返回</a>
</p>
<img src="img/2.jpg" alt="GIF Loader" data-gif="img/2.gif" class="gif">
	<!-- 遍历Map集合 -->
	<c:forEach var="me" items="${fileNameMap}">
		<c:url value="DownloadServlet" var="downurl">
			<c:param name="filename" value="${me.key}"></c:param>
		</c:url>
${me.value}<a href="${downurl}">下载</a>
		<br />
	</c:forEach>
</div>
<script src="js/jquery.1.7.1.min.js" type="text/javascript"></script>
<script src="js/jquery.gif.min.js"></script>
<script type="text/javascript">
	$( document ).ready(function() {
		$('.gif').each(function() {
			$(this).gif();
		});
	});
</script>
</body>
</html>
