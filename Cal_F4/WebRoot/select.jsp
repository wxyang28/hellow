<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ page language="java" import="com.lgs.bean.Ex" %>
<%
     Vector ti=(Vector)session.getAttribute("timu");
%>
<html>
  <head>
  <script>
   function queren(form)
   {
     if(document.getElementById("answer").value!=document.getElementById("panduan02").value)
     {
         document.getElementById("cuotizhengjie").value=document.getElementById("panduan02").value;
     }
     document.getElementById(form).submit();
    
   }
  </script>
  </head>
        
  <body>
  <div >
   <p align="right"><a href="login.jsp">退出登录</a></p>
    <br><br><br>
    <form name="suanshu" method="post" action="select">
    <tr><%=request.getSession().getAttribute("username").toString()%>请选择要进行的练习:</tr>
    <input type="hidden" id="user" 
    value=<%=request.getSession().getAttribute("username").toString()%>>
    <%
       //定义用户名
       String username=request.getSession().getAttribute("username").toString();
     %>
    <br>
    <tr>
      <select name="select">
   <option value="simple">简单四则运算</option>
   <option value="hard">混合四则运算</option>
   <option value="fen">真分数运算</option>
      </select>
     </tr>
     <tr>
     <input type="submit" value="提交"/>
      <input type="hidden" value="<%=username%>" name="username"/>
     </tr>
    </form>
  </div>
  </body>
</html>
