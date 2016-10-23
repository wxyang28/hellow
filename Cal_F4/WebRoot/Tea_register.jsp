 <%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@page import="javax.swing.JOptionPane" %>
<<html>
<head>
<title>注册新用户</title>
<script language="JavaScrpt" type="text/JavaScript">
  function checkform()
  {
    if(form.listRole.value=="")
    {
      alert("请输入用户名！");
      form.username.focus();
      return false;
    }
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
    if(form.realname==" ")
    {
     alert("请输入昵称！");
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
<body bgcolor="pink">
<br><br><br><br><br><br><br>
<%
   String de=(String)session.getAttribute("RegisterError");
   if(de==null)
   {
   }
   else
   {
      out.print("<script>alert('注册失败，用户名已存在，请重新注册！');</script>");
     //JOptionPane.showMessageDialog(null,de);
   }
%>
<div align="center">
 <form name="form" action="Register" method="post" align="middle" onsubmit="return checkform();">
 <table border="0" cellpadding="10">
 <tr>
    <td>请选择用户类型:</td><td><select  name="listRole">>
  <option value="student">学生</option>
  <option value="teacher">老师</option>

</select></td>
 </tr>
 <tr>
    <td>用户名:</td><td><input type="text" name="username"></input></td>
 </tr>
 <tr>
    <td>密码:</td><td><input type="password" name="password"></input></td>
 </tr>
 <tr>
    <td>昵称:</td> <td><input type="text" name="realname"></input></td>
 </tr>
 <tr valign="middle" align="center">
   <td>
     <input type="submit"  value="注册" />
   </td>
   <td>
    <input type="reset" value="重置" />
   </td>
 </tr>
 </table>
 </form>
</div>
</body>
</html>