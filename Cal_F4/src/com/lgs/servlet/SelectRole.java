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
		// 用于显示html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 设置提交表单的中文编码
		request.setCharacterEncoding("utf-8");
		// 设置session对象
		HttpSession mySession = request.getSession(true);
		// 获取dao对象
		Dao dao = new Dao();
		// 判断用户
		try {
			// 得到用户信息
			String sUsername = request.getParameter("username");
			String sPassword = request.getParameter("password");
			String sRole = request.getParameter("user");
			mySession.setAttribute("usernameView", sUsername);
			boolean de = dao.selectUser(sUsername, sRole, sPassword);
			System.out.println(de + " " + sRole);
			// 获取验证码信息
			String rand = (String) mySession.getAttribute("rand");
			String input = request.getParameter("rand");
			if (de&&rand.equals(input)) {
				// 根据用户角色的不同决定迁移到哪个页面
				if (sRole.equals("student")) {
					// 学生角色则迁移到选课一览页面
					mySession.setAttribute("judgefinish", "from");
					response.sendRedirect("student.jsp");
					//mySession.invalidate();
				} else if (sRole.equals("teacher")) {
					response.sendRedirect("teacher.jsp");
				}
			} else {
				mySession.setAttribute("loginError", "login");
				mySession.setAttribute("RegisterError", "登录出错请重新登陆！");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// 页面处理出错，跳转到首页
			e.printStackTrace();
			mySession.invalidate();
			response.sendRedirect("login.jsp");
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}
	// 题库

	// 得到用户的昵称

}
