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
		//设置提交表单的中文编码
        request.setCharacterEncoding("GBK");
        HttpSession mySession = request.getSession(true);
        //清空错误消息
          mySession.setAttribute("errMsg","");
        //获取dao对象
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
            //获得连接数据库
           
            conn=dao.getDBConnection();
            //创建statement
            stmt=conn.createStatement();
            rs=stmt.executeQuery(selectquery);
            //查看是否已经存在用户
            if(rs.next())
            {
              response.sendRedirect("register.html");
              JOptionPane.showMessageDialog(null, "用户已经存在", "用户已经存在", JOptionPane.CLOSED_OPTION);
            }
            else
            {
             stmt.executeUpdate(insertQuery);
             JOptionPane.showMessageDialog(null, "用户注册成功", "用户注册成功！", JOptionPane.CLOSED_OPTION);
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
