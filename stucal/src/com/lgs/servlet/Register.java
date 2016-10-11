package com.lgs.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.lgs.dao.Dao;
public class Register extends HttpServlet {

	
	public Register() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		      doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ύ�������ı���
        request.setCharacterEncoding("GBK");
        HttpSession mySession = request.getSession(true);
        //��մ�����Ϣ
          mySession.setAttribute("errMsg","");
        //��ȡdao����
          Dao dao=new Dao();
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
            }
            else
            {
             stmt.executeUpdate(insertQuery);
             JOptionPane.showMessageDialog(null, "�û�ע��ɹ�", "�û�ע��ɹ���", JOptionPane.CLOSED_OPTION);
             response.sendRedirect("login.jsp");
            }
          }
          catch(SQLException e)
          {
             e.printStackTrace();
          }
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
