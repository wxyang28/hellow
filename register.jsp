<%@page contentType="text/html;charset=gbk" %>
<%@page language="java" import="java.sql.*" %>
<%@page language="java" import="com.lgs.dao.Dao" %>
<%@page import="javax.swing.JOptionPane" %>
<%
   request.setCharacterEncoding("GBK");
   String sUsername,sPassword,sRealname,sRank;
   sUsername=request.getParameter("username");
   sUsername=sUsername.replaceAll("'","''");
   sPassword=request.getParameter("password");
   sPassword=sPassword.replaceAll("'","''");
   sRealname=request.getParameter("realname");
   sRealname=sRealname.replaceAll("'","''");
   sRank="0";
   String insertQuery="insert into user set username='"+sUsername+"',password='"+sPassword+"'+rank='"+sRank+"',realname='"+sRealname+"'";
   String selectquery="select * from user where username='"+sUsername+"'";
   Dao dao=new Dao();
   Connection conn=null;
   Statement stmt=null;
   ResultSet rs=null;
   try
   {
     //����������ݿ�
    
     conn=dao.getDBConnection();
     //����statement
     stmt=conn.createStatement();
     rs=stmt.executeQuery(selectquery);
     //�鿴�Ƿ��Ѿ������û�
     if(rs.next())
     {
       response.sendRedirect("register.html");
       JOptionPane.showMessageDialog(null, "�û��Ѿ�����", "�û��Ѿ�����", JOptionPane.CLOSED_OPTION);
       return;
     }
     else
     {
      stmt.executeUpdate(insertQuery);
     }
   }
   catch(SQLException e)
   {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "�û�ע��ɹ�", "�û�ע��ɹ���", JOptionPane.CLOSED_OPTION);
      response.sendRedirect("login.jsp");
   }
%>

