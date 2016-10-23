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

public class SelectExercise extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectExercise() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	// 获取dao对象
	Dao dao = new Dao();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置提交表单的中文编码
		request.setCharacterEncoding("utf-8");
		HttpSession mySession = request.getSession(true);
		//用户题的向量集合 
		Vector alltimu = null ;
		String kind = request.getParameter("select");
		String username=request.getParameter("username");
		Random r = new Random();
		System.out.println(kind+"....................3");
		if (kind.equals("simple")) {
			System.out.println("simple---------");
			String body;
			String head;
			for (int i = 0; i < 20; i++) {
				int s1 = r.nextInt(101);
				while(s1==0)
				{
					s1 = r.nextInt(101);
				}
				int s2 = r.nextInt(101);
				while(s2==0)
				{
					s2 = r.nextInt(101);
				}
				int s3 = r.nextInt(4);
				switch (s3) {
				case 0:
					body = s1+"+"+s2;
					head =s1+s2+"";
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					body = s1+"*"+s2;
					head = s1*s2+"";
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					int tempthis;
					if(s2>s1)
					{
						tempthis=s1;
						s1=s2;
						s2=tempthis;
					}
					body = s1+"-"+s2;
					head = (s1-s2)+"";
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					body = s1+"/"+s2;
					int ThisTemp1=Maxfunc(s1,s2);
					s1/=ThisTemp1;
					s2/=ThisTemp1;
					head = s1+"/"+s2;
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
		} else if (kind.equals("hard")) {
			System.out.println("");
			String body;
			String head;
			for (int i = 0; i < 20; i++) {
				int s1 = r.nextInt(101);
				while(s1==0)
				{
					s1 = r.nextInt(101);
				}
				int s2 = r.nextInt(101);
				while(s2==0)
				{
					s2 = r.nextInt(101);
				}
				int s3 = r.nextInt(101);
				while(s3==0)
				{
					s3 = r.nextInt(101);
				}
				int s4 = r.nextInt(101);
				while(s4==0)
				{
					s4 = r.nextInt(101);
				}
				int s5 = r.nextInt(101);
				while(s5==0)
				{
					s5 = r.nextInt(101);
				}
				int s6 = r.nextInt(4);
				switch (s6) {
				case 0:
					body = s1 + "+" + s2 + "-" + s3 +"*"+s4;
					head =s1+s2-s3*s4+"";
					System.out.println(body+" "+head);
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					body = s1 + "+" + s2 + "-" + s3 +"/"+ s4;
					int temp6=(s1+s2)*s4-s3;
					int temp7=Maxfunc(temp6,s4);
					temp6/=temp7;
				    s4/=temp7;
					head = (temp6+"/"+s4)+"";
					System.out.println(body+" *"+head);
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					body = s1 + "*" + s2 + "+" + s3 + "/" + s4;
					int temp8=s1*s2*s4+s3;
					int temp9=Maxfunc(temp8,s4);
					temp8/=temp9;
					s4/=temp9;
					head = ( temp8+"/"+s4)+"";
					System.out.println(body+" **"+head);
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					body = s1 + "+" + s2 + "-" + s3 + "*" + s4 + "/" + s5;
					int temp10=(s1+s2)*s5-s3*s4;
					int temp11=Maxfunc(temp10,s5);;
					temp10/=temp11;
					s5/=temp11;
					head = (temp10+"/"+s5)+"";
					System.out.println(body+"***"+head);
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
		} else if(kind.equals("properfraction")) {
			System.out.println("fen");
			String body;
			String head;
			for (int i = 0; i < 20; i++) {
				int s1 = r.nextInt(101);
				while(s1==0)
				{
					s1 = r.nextInt(101);
				}
				int s2 = r.nextInt(101);
				while(s2==0)
				{
					s2 = r.nextInt(101);
				}
				int s3 = r.nextInt(101);
				while(s3==0)
				{
					s3 = r.nextInt(101);
				}
				int s4 = r.nextInt(101);
				while(s4==0)
				{
					s4 = r.nextInt(101);
				}
				int temp1;
				int temp2;
				int temp3;
				int s6 = r.nextInt(4);
				switch (s6) {
				case 0:
					temp1 = s2 * s4;
					temp2 = s1 * s4 + s2 * s3;
					temp3 = Maxfunc(temp1, temp2);
					temp1 /= temp3;
					temp2 /= temp3;
					body = s1 + "/" + s2 + "+" + s3+ "/" + s4;
					head = temp2 + "/" + temp1;
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					temp1 = s2 * s4;
					temp2 = s1 * s3;
					temp3 = Maxfunc(temp1, temp2);
					temp1 /= temp3;
					temp2 /= temp3;
					body = s1 + "/" + s2 + "*" + s3 + "/" + s4;
					head =temp2 + "/" + temp1;
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					temp1 = s2 * s4;
					temp2 = s1 * s4 - s2 * s3;
					temp3 = Maxfunc(temp1, temp2);
					temp1 /= temp3;
					temp2 /= temp3;
					body = s1 + "/" + s2 + "-" + s3+ "/" + s4;
					head =temp2 + "/" + temp1;
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
					temp1 = s2 * s3;
					temp2 = s1 * s4;
					temp3 = Maxfunc(temp1, temp2);
					temp1 /= temp3;
					temp2 /= temp3;
					body = s1 + "/" + s2 + "/" + s3 + "/" + s4;
					head = temp2 + "/" + temp1;
					try {
						boolean c = dao.insertexercise(kind, body, head);
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
		// 返回jsp页面显示结果
		try {
		    alltimu = getSelectItem(kind);
			mySession.setAttribute("timu", alltimu);
			mySession.setAttribute("kind", kind);
			mySession.setAttribute("exuname",username);
			response.sendRedirect("exercise.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(alltimu.size()+"------------2");
	}
	
	
	// 求最大公约数
	public int Maxfunc(int a, int b) {// 分子分母最大公约数
		// TODO Auto-generated method stub
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	// 获取用户所对应的题目

	private Vector getSelectItem(String kind) throws SQLException {
		// 获得数据库连接
		Connection conn = dao.getDBConnection();
		if (conn == null) {
			return null;
		}
		Statement stmt;
		ResultSet rs;
		stmt = null;
		rs = null;
		try {
			stmt = conn.createStatement();
			// 执行sql语句
			String sQuery = "select * from exercise where kind='"+ kind + "'";
			rs = stmt.executeQuery(sQuery);
			// 留着在页面上显示题目列表
			Vector timu = new Vector();
			int i = 0;
			while (rs.next()) {
				i++;
				Ex ti = new Ex();
				ti.setBody(rs.getString("body"));
				ti.setHead(rs.getString("head"));
				if (i > 20) {
					break;
				}
				timu.add(ti);
				System.out.println(i+"------------1");
			}
			return timu;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
