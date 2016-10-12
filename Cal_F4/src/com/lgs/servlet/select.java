package com.lgs.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lgs.bean.Ex;
import com.lgs.dao.Dao;

public class select extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public select() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
    //获取dao对象
	 Dao dao=new Dao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
        HttpSession mySession = request.getSession(true);
        //清空错误消息
          mySession.setAttribute("errMsg","");
      //用户选题
        String kind=request.getParameter("select");
        Random r=new Random();
        if(kind=="simple")
        {   
      	  String body;
            String head;
      	  for(int i=0;i<20;i++)
      	  {
      		  int s1=r.nextInt(100);
      		  int s2=r.nextInt(100);
      		  int s3=r.nextInt(3);
      		  switch (s3)
      		  {
      		  case 0:
      			  body=s1+"+"+s2;
      			  head="="+s1+s2;
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      		    break;
      		  case 1:
      			  body=s1+"*"+s2;
      			  head="="+s1*s2;
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  case 2:
      			  body=s1+"-"+s2;
      			  head="="+(s1-s2);
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  case 3:
      			  body=s1+"/"+s2;
      			  head="="+s1/s2;
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  }
      	  }
        }
        else if(kind=="hard")
        {
      	  String body;
            String head;
      	  for(int i=0;i<20;i++)
      	  {
      		  int s1=r.nextInt(100);
      		  int s2=r.nextInt(100);
      		  int s3=r.nextInt(100);
      		  int s4=r.nextInt(100);
      		  int s5=r.nextInt(100);
      		  int s6=r.nextInt(3);
      		  switch (s6)
      		  {
      		  case 0:
      			  body=s1+"+"+s2+"-"+s3*s4;
      			  head="="+(s1+s2-s3*s4);
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      		    break;
      		  case 1:
      			  body=s1+"+"+s2+"-"+s3/s4;
      			  head="="+(s1+s2-s3/s4);
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  case 2:
      			  body=s1+"*"+s2+"+"+s3+"/"+s4;
      			  head="="+(s1*s2+s3/s4);
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  case 3:
      			  body=s1+"+"+s2+"-"+s3+"*"+s4+"/"+s5;
      			  head="="+(s1+s2-s3*s4/s5);
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  }
      	  }
        }
        else
        {
      	  String body;
            String head;
      	  for(int i=0;i<20;i++)
      	  {
      		  int s1=r.nextInt(100);
      		  int s2=r.nextInt(100);
      		  int s3=r.nextInt(100);
      		  int s4=r.nextInt(100);
      		  int temp1;
      		  int temp2;
      		  int temp3;
      		  int s6=r.nextInt(3);
      		  switch (s6)
      		  {
      		  case 0:
      		      temp1=s2*s4;
      		      temp2=s1*s4+s2*s3;
      		      temp3=Maxfunc(temp1, temp2);
      		      temp1/=temp3;
      		      temp2/=temp3;
      			  body=s1+"/"+s2+"+"+s3/s4;
      			  head="="+temp2+"/"+temp1;
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      		    break;
      		  case 1:
      			  temp1=s2*s4;
      		      temp2=s1*s3;
      		      temp3=Maxfunc(temp1, temp2);
      		      temp1/=temp3;
      		      temp2/=temp3;
      			  body=s1+"/"+s2+"*"+s3/s4;
      			  head="="+temp2+"/"+temp1;
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  case 2:
      			  temp1=s2*s4;
      		      temp2=s1*s4-s2*s3;
      		      temp3=Maxfunc(temp1, temp2);
      		      temp1/=temp3;
      		      temp2/=temp3;
      			  body=s1+"/"+s2+"-"+s3/s4;
      			  head="="+temp2+"/"+temp1;
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  case 3:
      			  temp1=s2*s3;
      		      temp2=s1*s4;
      		      temp3=Maxfunc(temp1, temp2);
      		      temp1/=temp3;
      		      temp2/=temp3;
      			  body=s1+"/"+s2+"/"+s3/s4;
      			  head="="+temp2+"/"+temp1;
      			  try {
						boolean c=dao.insertTiku(kind, body, head);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
      			break;
      		  }
      	  }  
        }
        //返回jsp页面显示结果
        try {
			 Vector alltimu=getSelectItem(kind);
			 mySession.setAttribute( "timu", alltimu);
			 mySession.setAttribute( "kind", kind);
		     response.sendRedirect("../select.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	
	}
	//求最大公约数
		public int Maxfunc(int a, int b) {//分子分母最大公约数
	        // TODO Auto-generated method stub
	        while(b != 0) 
	        {
	            int temp = a%b;
	            a = b;
	            b = temp;
	        }
	        return a;
	    }
	//获取用户所对应的题目
		
	private Vector getSelectItem(String kind) throws SQLException
	{
		//获得数据库连接
		Connection conn=dao.getDBConnection();
		if(conn==null)
		{
			return null;
		}
		Statement stmt;
		ResultSet rs;
		stmt=null;
		rs=null;
		try
		{
			stmt=conn.createStatement();
			//执行sql语句
			String sQuery="select body head from Ex where kind='"+kind+"'";
			rs=stmt.executeQuery(sQuery);
			//留着在页面上显示题目列表
			Vector timu=new Vector();
			int i=0;
			while(rs.next())
			{   i++;
				Ex ti=new Ex();
				ti.setBody(rs.getString("body"));
				ti.setHead(rs.getString("head"));
				if(i>19)
				{
					break;
				}
			}
			return timu;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
		   rs.close();
		   stmt.close();
		   conn.close();
		}
		
	}
	public void init() throws ServletException {
		// Put your code here
	}
    
}






 


























