<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ page language="java" import="com.lgs.bean.tiku" %>
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
   <p align="right"><a href="login.jsp">�˳���¼</a></p>
    <br><br><br>
    <form name="suanshu" method="post" action="select">
    <tr><%=request.getSession().getAttribute("username").toString()%>��ѡ��Ҫ���е���ϰ:</tr>
    <input type="hidden" id="user" 
    value=<%=request.getSession().getAttribute("username").toString()%>>
    <%
       //�����û���
       String username=request.getSession().getAttribute("username").toString();
     %>
    <br>
    <tr>
      <select name="select">
   <option value="simple">����������</option>
   <option value="hard">�����������</option>
   <option value="fen">���������</option>
      </select>
     </tr>
     <tr>
     <input type="submit" value="�ύ"/>
      <input type="hidden" value="<%=username%>" name="username"/>
     </tr>
    </form>
  </div>
  </body>
</html>
