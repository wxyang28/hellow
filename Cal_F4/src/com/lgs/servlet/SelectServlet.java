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
public class SelectServlet extends HttpServlet {

	
	public SelectServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost( request, response );
		
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
        //�ж��û�
        try
        {
            //�õ��û���Ϣ
        	String sUsername=request.getParameter("username");
        	String sPassword=request.getParameter("password");
        	String sRole=request.getParameter("user");
        	String sRealname=dao.getUserRealname(sUsername, sPassword, sRole);
        	if(sRealname==null)
        	{
        		//�������ñ�����������ʾ
        		 mySession.setAttribute( "errMsg", "��¼ʧ�ܣ����������������Ϣ��" );
                 mySession.setAttribute( "username", sUsername );
                 mySession.setAttribute( "role", sRole );
                 response.sendRedirect("../login.jsp");
        	}
        	else
        	{

                mySession.setAttribute( "username", sUsername );
                mySession.setAttribute( "realname", sRealname );
                //�����û���ɫ�Ĳ�ͬ����Ǩ�Ƶ��ĸ�ҳ��
                if ( sRole.equals( "student" ) )
                {
                    //ѧ����ɫ��Ǩ�Ƶ�ѡ��һ��ҳ��
                    response.sendRedirect( "../teacher.jsp" );
                }
                else if(sRole.equals(""))
                {
                    //��ʦ��ɫ��Ǩ�Ƶ�ѡ�ν��һ��ҳ��
                    response.sendRedirect( "../parent.jsp" );
                }
                else
                {
                	
                }
        	}
        }
        catch(Exception e)
        {
            //ҳ�洦�������ת����ҳ
            e.printStackTrace();
            mySession.invalidate();
            response.sendRedirect("../login.jsp");
        }
        
        
		
	}
	
	public void init() throws ServletException {
		// Put your code here
	}
	//���
	
	//�õ��û����ǳ�
	

}
