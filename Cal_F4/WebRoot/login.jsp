<%@page contentType="text/html;charset=gbk" %>
<%@page language="java" import="java.util.*" %>
<html>
<head>
  <title>���¼������ϵͳ</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gbk">
  <script language="JAVASCRIPT" src="login.js"></script>
</head>

<body>
<p align="right"><a href="register.html" >ע�����û�</a></p>
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
          <td align=center>  ��ѡ���û�����:
       
<input type="radio" checked="checked" name="user" value="student" />
   ѧ��      
    
<input type="radio" name="user" value="teacher" />
 ��ʦ
  
<input type="radio" name="user" value="parents" />
  �ҳ�       </td>
      </tr>      
</table>
<table align=center cellpadding="3">
        <tr>
             <td align=center>�û���:</td>
             <td>
                  <input type="text" name="username" size=20 maxlength=20  class="login_input"></input>
             </td>
       </tr>
       <tr>
         <td align=center>����:</td>
            <td>
               <input type="password" name="password" size=20 maxlength=20 class="login_input"></input>
            </td>
       </tr>
       <tr>
       <td></td>
       </tr>
       <tr align="center">
          <td >
            <input type="submit" value="��¼"></input>
          </td>
          <td>
           <input type="reset" value="����"></input>
          </td>
       </tr>
      <tr>
          <td height=10></td>
      </tr>
</table>
</form>
</body>
</html>