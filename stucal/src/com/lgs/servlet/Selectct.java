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
		//�����ύ�������ı���
        request.setCharacterEncoding("GBK");
        HttpSession mySession = request.getSession(true);
        //��մ�����Ϣ
          mySession.setAttribute("errMsg","");
        //��ȡdao����
          Dao dao=new Dao();
        //��ȡ��Ŀ��Ϣ
          String sErrContent=request.getParameter("cuotizhengjie");
          String sErr=request.getParameter("question");
          String sUser=request.getParameter("username");
          String sHead=request.getParameter("head");
       //�ж��û��Ƿ�����������Ͳ��뵽�����
          if(sErrContent!=null||sErrContent!="")
          {
        	  
          }
		  
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
