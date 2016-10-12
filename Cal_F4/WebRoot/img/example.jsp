<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'example.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
	<% for(int i=0;i<20; i++){ %>
		<form id="form<%=i%>"action="" method="post">
			<table>
				<tr>
					<td>表達式</td>
					<td><input type="text" id="exp" name="exp" value="${exp }"/></td>
					<td>結果</td>
					<td><input type="text" id="result" name="result" value=""/></td>
					<td><input type="button" value="提交" onclick="sub(form<%=i%>)"></td>
					</tr>
				<%=session%>	
			</table>
		</form>
	<%} %>
	<script type="text/javascript">
		function sub(form){
			document.getElementById(form).submit();
		}
	</script>
  </body>
</html>
