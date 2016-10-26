package com.lgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lgs.dao.Dao;

public class SelectRole extends HttpServlet {

	public SelectRole() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		HttpSession mySession = request.getSession(true);
		Dao dao = new Dao();
		try {
			String sUsername = request.getParameter("username");
			String sPassword = request.getParameter("password");
			String sRole = request.getParameter("user");
			mySession.setAttribute("usernameView", sUsername);
			boolean de = dao.selectUser(sUsername, sRole, sPassword);
			if (de) {
				if (sRole.equals("student")) {
					mySession.setAttribute("judgefinish", "from");
					response.sendRedirect("student.jsp");
				} else if (sRole.equals("teacher")) {
					response.sendRedirect("teacher.jsp");
				}
			} else {
				mySession.setAttribute("loginError", "login");
				mySession.setAttribute("RegisterError", "登录出错请重新登陆！");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mySession.invalidate();
			response.sendRedirect("login.jsp");
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
