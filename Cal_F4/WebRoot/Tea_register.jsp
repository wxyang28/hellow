<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@page import="javax.swing.JOptionPane" %>
<link rel="stylesheet" href="CSS/style.css"  type='text/css'/>
<html>
<head>
<title>注册新用户</title>
<script language="JavaScrpt" type="text/JavaScript">
function checkform()
{
    if(form.username.value=="")
    {
      alert("请输入用户名！");
      form.username.focus();
      return false;
    }
    if(form.password.value=="")
    {
      alert("请输入密码！");
      form.password.focus();
      return false;
    }
    if(form.realname=="")
    {
     alert("请输入姓名！");
     form.realname.focus();
     return false;
    }
    return true; 
}
</script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/easyBackground-min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('body').easyBackground({
		wrapNeighbours: true
	});
});
</script>
<%
   String de=(String)session.getAttribute("RegisterError");
   if(de==null)
   {
   }
   else
   {
      out.print("<script>alert('注册失败，用户名已存在，请重新注册！');</script>");
   }
%>
<div class="lg-container" align="center">
	<h1>Register Area</h1>
	<form name="form" action="Register" id="lg-form" method="post" onsubmit="return checkform();">
 		<div>请选择用户类型
			<select  name="listRole">>
				<option value="student">学生</option>
				<option value="teacher">老师</option>
			</select>
		</div>
 		<div>
 			<table >
 			<tr>
			<td>用户名:</td>
			<td><input  type="text" name="username"/></td>
			</tr>
			<tr>
			<td>密&nbsp;&nbsp;&nbsp;码:</td>
			<td>
			<input type="password" name="password"/>
			</td>
			</tr>
			<tr>
			<td>姓&nbsp;&nbsp;&nbsp;名:</td>
			<td>
			<input type="text" name="realname"/>
			</td>
			</tr>
			</table>
		</div>
		<div>
			<input type="submit"  id="login" style="margin-left:20px;" value="注册" />
			<input type="reset"  id="login" style="margin-left:20px;" value="重置" />
		</div>
 	</form>
</div>
</body>
</html>