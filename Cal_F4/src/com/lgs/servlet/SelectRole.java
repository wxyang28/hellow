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
		// ������ʾhtml
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// �����ύ�������ı���
		request.setCharacterEncoding("utf-8");
		// ����session����
		HttpSession mySession = request.getSession(true);
		// ��ȡdao����
		Dao dao = new Dao();
		// �ж��û�
		try {
			// �õ��û���Ϣ
			String sUsername = request.getParameter("username");
			String sPassword = request.getParameter("password");
			String sRole = request.getParameter("user");
			mySession.setAttribute("usernameView", sUsername);
			boolean de = dao.selectUser(sUsername, sRole, sPassword);
			System.out.println(de + " " + sRole);
			// ��ȡ��֤����Ϣ
			String rand = (String) mySession.getAttribute("rand");
			String input = request.getParameter("rand");
			if (de&&rand.equals(input)) {
				// �����û���ɫ�Ĳ�ͬ����Ǩ�Ƶ��ĸ�ҳ��
				if (sRole.equals("student")) {
					// ѧ����ɫ��Ǩ�Ƶ�ѡ��һ��ҳ��
					mySession.setAttribute("judgefinish", "from");
					response.sendRedirect("student.jsp");
					//mySession.invalidate();
				} else if (sRole.equals("teacher")) {
					response.sendRedirect("teacher.jsp");
				}
			} else {
				mySession.setAttribute("loginError", "login");
				mySession.setAttribute("RegisterError", "��¼���������µ�½��");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// ҳ�洦�������ת����ҳ
			e.printStackTrace();
			mySession.invalidate();
			response.sendRedirect("login.jsp");
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}
	// ���

	// �õ��û����ǳ�

}
