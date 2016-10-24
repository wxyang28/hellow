<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>文件上传</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body background="img/bg_ssg.png" style="background-repeat:no-repeat; background-position:1080px  200px; background-color:#FFFACD;">
	<p align="right">
		<a href="teacher.jsp">返回</a>
	</p>
	<form action="${pageContext.request.contextPath}/UploadServlet"
		enctype="multipart/form-data" method="post">
		上传文件1：<input type="file" name="file1"><br /> 上传文件2：<input
			type="file" name="file2"><br /> 上传文件3：<input type="file"
			name="file3"><br /> <input type="submit" value="提交">
	</form>
</body>
</html>
