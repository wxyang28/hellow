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

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession mySession = request.getSession(true);
		Dao dao = new Dao();
		String sUsername, sPassword, sRealname, sRole;
		sUsername = request.getParameter("username").toString();
		sPassword = request.getParameter("password").toString();
		sRealname = request.getParameter("realname").toString();
		sRole = request.getParameter("listRole").toString();
		String insertQuery = "insert into user set username='" + sUsername
				+ "',upassword='" + sPassword + "',rank='" + sRole
				+ "',realname='" + sRealname + "'";
		String selectquery = "select * from user where username='" + sUsername
				+ "'and rank='" + sRole + "'";
		try {
		
			Connection conn = dao.getDBConnection();
		
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectquery);
	
			if (rs.next()) {
				mySession.setAttribute("RegisterError", "error");
				response.sendRedirect("Tea_register.jsp");

			} else {
				mySession.setAttribute("RegisterError", "注册成功！");
				mySession.setAttribute("loginError","error");
				stmt.executeUpdate(insertQuery);
				response.sendRedirect("login.jsp");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
