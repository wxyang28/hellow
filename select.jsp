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
   <p align="right"><a href="login.jsp">�˳���¼</a></p>
    <br><br><br>
    <form name="suanshu" method="post" action="select">
    <tr><%=request.getSession().getAttribute("username").toString()%>��ѡ��Ҫ���е���ϰ:</tr>
    <input type="hidden" id="user" 
    value=<%=request.getSession().getAttribute("username").toString()%>>
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
            ���ڽ��е���<font color=blue><%=session.getAttribute("kind")%></font>�Ѷȵ���ϰ
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
                      ��Ŀ
                </td>
                <td width=80 align=center>
                  ��д��
                </td>
                <td width=80 align=center>
       ȷ��
                </td>
                <td width=80 align=center>
          �Ƿ���ȷ
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
                   <button onclick="queren()" >�ύ</button>
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
<p align="center"><input type="submit" value="������ϰ" /></p>
</form>
    </div>
  </body>
</html>
