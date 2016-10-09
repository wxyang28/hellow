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
		//设置提交表单的中文编码
        request.setCharacterEncoding("GBK");
        HttpSession mySession = request.getSession(true);
        //清空错误消息
          mySession.setAttribute("errMsg","");
        //获取dao对象
          Dao dao=new Dao();
        //判断用户
        try
        {
            //得到用户信息
        	String sUsername=request.getParameter("username");
        	String sPassword=request.getParameter("password");
        	String sRole=request.getParameter("user");
        	String sRealname=dao.getUserRealname(sUsername, sPassword, sRole);
        	if(sRealname==null)
        	{
        		//出错设置变量并重新显示
        		 mySession.setAttribute( "errMsg", "登录失败！请重新输入相关信息！" );
                 mySession.setAttribute( "username", sUsername );
                 mySession.setAttribute( "role", sRole );
                 response.sendRedirect("../login.jsp");
                 return;
        	}
        	else
        	{

                mySession.setAttribute( "username", sUsername );
                mySession.setAttribute( "realname", sRealname );
                //根据用户角色的不同决定迁移到哪个页面
                if ( sRole.equals( "student" ) )
                {
                    //学生角色则迁移到选课一览页面
                    response.sendRedirect( "../select.jsp" );
                }
                else
                {
                    //教师角色则迁移到选课结果一览页面
                    response.sendRedirect( "../change.jsp" );
                }
//                return;
                
                request.getRequestDispatcher("../change.jsp").forward(request, response);
        	}
        }
        catch(Exception e)
        {
            //页面处理出错，跳转到首页
            e.printStackTrace();
            mySession.invalidate();
            response.sendRedirect("../login.jsp");
            return;
        }
        
        
		
	}
	
	public void init() throws ServletException {
		// Put your code here
	}
	//题库
	
	//得到用户的昵称
	

}
