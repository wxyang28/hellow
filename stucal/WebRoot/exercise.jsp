<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page language="java" import="com.lgs.bean.tiku" %>
<%
     Vector ti=(Vector)session.getAttribute("timu");
%>
<html>
  <head>

  </head>
  
  <body>
    <%String username=request.getParameter("username").toString();%>
    <div>
    <%for(int i=0;i<20;i++ ){%>
         <form name="form_main<%=i%>" action="Selectct" method="post" >
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
        ����
                </td>
                <%
    tiku ti01=(tiku)ti.get(i);
                %>
              <tr>
                <td>
                  <input type="text" id="body" value="<%=ti01.getBody()%>" name="question"/>
                </td>
                <td>
                  <input type="text" id="answer"/>
                </td>
                <td width=50>
                   <input type="button" value="�ύ" onclick="queren(form<%=i%>)" />
                </td >
                <td>
                 <input type="hidden" value="<%=ti01.getHead()%>" id="panduan02" name="head"/>
                 <input type="text" name="cuotizhengjie">
                 <input type="hidden" value="<%=username%>" name="username"/>
                </td>

             </tr>

         
<%} %>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</form>
    </div>
  </body>
</html>
