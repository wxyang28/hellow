<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@ page language="java" import="com.lgs.bean.tiku" %>
<%
     Vector ti=(Vector)session.getAttribute("timu");
%>
<html>
  <head>
  <script>
   function queren()
   {
     if(document.getElementById("answer").value!=document.getElementById("panduan02").value)
     {
         document.getElementById("panduan01").value=document.getElementById("panduan02").value;
     }
     else
     {
       var username=document.getElementById("user").value;
       var body=document.getElementById("body").value;
       var head=document.getElementById("head").value;
       importClass(com.lgs.dao.Dao);
       Dao a=new Dao();
       a. insertCuotiku(username,body,head);
     }
    
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
     </tr>
    </form>
  </div>
    
    <div align=bottom>
         <form name="form_main" action="Selectct" method="post" >
<table  cellspacing=2  align=center>
  <tr>
    <td>
      <table cellspacing=3 width=700>
        <tr>
          <td align=left height=20>
            现在进行的是<font color=blue><%=session.getAttribute("kind")%></font>难度的练习
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table width=700>
        <tr>
          <td height=5>
          </td>
        </tr>
        <tr>
          <td align=center height=300 valign=top>
            <table cellspacing=2 bgcolor="#ffffff" width=680>
              <tr bgcolor=#cccccc height=18>
                <td width=300 align=center>
                      题目
                </td>
                <td width=80 align=center>
                  填写答案
                </td>
                <td width=80 align=center>
       确认
                </td>
                <td width=80 align=center>
          是否正确
                </td>
         
<%
for ( int i=0; i<ti.size(); i++ )
{
    tiku ti01=(tiku)ti.get(i);
%>
              <tr>
                <td>
                  <input type="text" id="body" value=<%=ti01.getBody()%>>
                </td>
                <td>
                  <input type="text" id="answer"/>
                </td>
                <td width=50>
                   <button onclick="queren()" >提交</button>
                </td >
                <td>
                   <input type="text"  id="panduan01">
                </td> 
                <td>
                 <input type="hidden" value=<%=ti01.getHead()%> id="panduan02">
                </td>
             </tr>
<%
}
%>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<p align="center"><input type="submit" value="错题练习" /></p>
</form>
    </div>
  </body>
</html>
