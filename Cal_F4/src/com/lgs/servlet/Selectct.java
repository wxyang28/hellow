package com.lgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lgs.dao.Dao;

public class Selectct extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Selectct() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
        //获取题目信息
          String sErrContent=request.getParameter("cuotizhengjie");
          String sErr=request.getParameter("question");
          String sUser=request.getParameter("username");
          String sHead=request.getParameter("head");
       //判断用户是否做错，若做错就插入到错题表
          if(sErrContent!=null||sErrContent!="")
          {
        	  
          }
		  
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
