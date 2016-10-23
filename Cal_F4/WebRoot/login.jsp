<%@page contentType="text/html;charset=utf-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="javax.swing.JOptionPane"%>
<html>
<head>
<title>请登录四则考试系统</title>
<script language="JAVASCRIPT" type="text/JavaScript">
  function checkInput()
{
    //检查用户名
    if ( form_main.username.value.length < 1 )
    {
        form_main.username.focus();
        form_main.username.select();
        alert("用户名不能为空！");
        return false;
    }
    
    //检查密码
    if ( form_main.password.value.length < 1 )
    {
        form_main.password.focus();
        form_main.password.select();
        alert("密码不能为空！");
        return false;
    }
    return true;
}
  
  </script>
<script language="javascript"> 
function loadimage(){ 
document.getElementById("randImage").src = "image.jsp?"+Math.random(); 
} 
</script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body background="img/xiong02.jpg">

	<%
		//设置sessionID
		session.setAttribute("idCard", "judge");
		String de = (String) session.getAttribute("loginError");
		if(de==null)
		{
		}
		else if (de=="error") {
		} 
		else if(de.equals("login"))
		{
			out.print("<script>alert('登录出错请重新登录！');</script>");
			//session.invalidate();
			//JOptionPane.showMessageDialog(null, de);
		}
	%>
	<p align="right">
		<a href="Tea_register.jsp">注册新用户</a>
	</p>
	<%
		String de1 = (String) session.getAttribute("RegisterError");
		if (de1 == null) {
		} else if (de.equals("error")) {
			out.print("<script>alert('注册成功!');</script>");
			//session.invalidate();
			//JOptionPane.showMessageDialog(null, de1);
		}
	%>
	<form name="form_main" action="SelectRole" method="post"
		onsubmit="return checkInput();">
		<table align=center cellpadding="10">
			<tr>
				<td><img src="img/loginlogo.gif"></img>
				</td>
			</tr>
			<tr>
				<td height=5></td>
			</tr>
			<tr>
				<td align=center>请选择用户类型: <input type="radio" checked="checked"
					name="user" value="student" /> 学生 <input type="radio" name="user"
					value="teacher" /> 老师
			</tr>
		</table>
		<table align=center cellpadding="3">
			<tr>
				<td align=center>用户名:</td>
				<td><input type="text" name="username" size=20 maxlength=20
					class="login_input"></input>
				</td>
			</tr>
			<tr>
				<td align=center>密码:</td>
				<td><input type="password" name="password" size=20 maxlength=20
					class="login_input"></input>
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td width="118" height="22" valign="middle" align="center"><input
					type="text" name="rand" size="15"></td>
				<td width="138" valign="middle" align="center"><img alt="snail"
					name="randImage" id="randImage" src="image.jsp" width="60"
					height="20" border="1" align="absmiddle" /></td>
			</tr>
			<tr>
				<td height="36" colspan="2" align="center" valign="middle"><a
					href="javascript:loadimage();"><font class=pt95>看不清点我</font> </a></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="登录"></input>
				</td>
				<td><input type="reset" value="重置"></input>
				</td>
			</tr>
			<tr>
				<td height=10></td>
			</tr>
		</table>
	</form>
</body>
</html>