<%@page contentType="text/html;charset=gbk" %>
<%@page language="java" import="java.util.*" %>
<html>
<head>
  <title>请登录四则考试系统</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gbk">
  <script language="JAVASCRIPT" src="login.js"></script>
</head>

<body>
<p align="right"><a href="register.html" >注册新用户</a></p>
<form name="form_main" action="SelectServlet" method="post" 
      onsubmit="return checkInput();">
<table  align=center cellpadding="10">
        <tr>
          <td>
            <img border=0 src="img/loginlogo.gif"></img>
          </td>
        </tr>
        <tr>
          <td height=5></td>
        </tr>
        <tr>
          <td align=center>  请选择用户类型:
       
<input type="radio" checked="checked" name="user" value="student" />
   学生      
    
<input type="radio" name="user" value="teacher" />
 老师
  
<input type="radio" name="user" value="parents" />
  家长       </td>
      </tr>      
</table>
<table align=center cellpadding="3">
        <tr>
             <td align=center>用户名:</td>
             <td>
                  <input type="text" name="username" size=20 maxlength=20  class="login_input"></input>
             </td>
       </tr>
       <tr>
         <td align=center>密码:</td>
            <td>
               <input type="password" name="password" size=20 maxlength=20 class="login_input"></input>
            </td>
       </tr>
       <tr>
       <td></td>
       </tr>
       <tr align="center">
          <td >
            <input type="submit" value="登录"></input>
          </td>
          <td>
           <input type="reset" value="重置"></input>
          </td>
       </tr>
      <tr>
          <td height=10></td>
      </tr>
</table>
</form>
</body>
</html>