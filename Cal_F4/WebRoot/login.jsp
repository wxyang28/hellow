<%@page contentType="text/html;charset=utf-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="javax.swing.JOptionPane"%>
<link rel="stylesheet" href="CSS/style.css"  type='text/css'/>
<script type="text/javascript" src="jquery-1.7.min.js"></script>
<script type="text/javascript" language="JAVASCRIPT" >	
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

<html>
<head>
<title>请登录四则考试系统</title>
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
	    session.setAttribute("idCard","judge");
		String de = (String) session.getAttribute("loginError");
		if (de == null) {
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
		<a href="Tea_register.jsp" style="color:#FFFFFF;">注册新用户</a>
	</p>
		<%
		String de1 = (String) session.getAttribute("RegisterError");
		if (de1 == null) {
		} else if (de.equals("error"))  {
			out.print("<script>alert('注册成功!');</script>");
			//session.invalidate();
			//JOptionPane.showMessageDialog(null, de1);
		}
	%>
		<div class="lg-container">
		<h1>Admin Area</h1>
		<form name="form_main" action="SelectRole" id="lg-form" method="post" onsubmit="return checkInput();">
			<div>
				用户类型: 
				<input type="radio" checked="checked" name="user" value="student" /> 学生 
				<input type="radio" name="user" value="teacher" /> 老师
			</div>
			<div>
				<label for="username">Username:</label>
				<input type="text" name="username" id="username" placeholder="username" class="login_input"/>
			</div>

			<div>
				<label for="password">Password:</label>
				<input type="password" name="password" id="password" placeholder="password" class="login_input"/>
			</div>
			<div>
				<button type="reset" id="login" style="margin-left:50px;">Reset</button>
				<button type="submit" id="login" style="margin-left:20px;">Login</button>
			</div>
		</form>
		</div>
</body>
</html>