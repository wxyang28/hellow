package com.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lgs.dao.Dao;

public class JudgeItem extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JudgeItem() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置提交表单的中文编码
		request.setCharacterEncoding("utf-8");
		// 设置session对象
		HttpSession mySession = request.getSession(true);
		// 获取dao对象
		Dao dao = new Dao();
		// 判断是否插入
		String isTrue = null;
		String sBody = null;
		String sHead = null;
		int num = 0;
		int count = 0;
		double startTime = (Double) mySession.getAttribute("startTime");
		String username = mySession.getAttribute("usernameEr").toString();
		int ECount = Integer.parseInt(request.getParameter("count").toString());    
		System.out.println(ECount+"***************88");
		for (int i = 0; i < 20; i++) {
			// 获取题目信息
			count++;
			sBody = mySession.getAttribute("question"+i).toString();
			sHead = mySession.getAttribute("head"+i).toString();
			// 判断用户是否做错，若做错就插入到错题表
				String p = request.getParameter(i+1+"").toString();
				if (p.equals("false")) {
					dao.insertError_ex(username, sBody, sHead);
				}
				else if(p.equals("true"))
				{
					num++;
				}
				System.out.println(p + "******************8");
				// if (p != null || p != "") {
				// num++;
				// isTrue ="true";
				// } else {
				// isTrue ="false";
				// }

				System.out.println(sBody + "**** " + sHead
						+ "1111111111111111111");
				//count++;
				System.out.println(count + "-----------------6");
				
				
			if (count == 20) {
				double endTime = System.currentTimeMillis();
				String timeSum = (endTime-startTime) / 1000-2 + "s";
				dao.insertGrade(username, num * 5 + "", timeSum);
				mySession.setAttribute("judgefinish", "finish");
				//mySession.invalidate();
				response.sendRedirect("student.jsp");
				break;
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
