package com.lgs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.lgs.bean.User;
import com.lgs.bean.grade;

public class Dao {
	// 获取数据库连接
	public Connection getDBConnection() {
		// 尝试连接数据库
		try {
			// 载入MySQL的JDBC驱动类
			Class.forName("com.mysql.jdbc.Driver");
			// 获得数据库连接
			Connection conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?"
									+ "useUnicode=true&characterEncoding=gbk&useSSL=true",
							"root", "123456");

			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// 插入成绩
	public boolean insertGrade(String username, String score, String time) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// 执行sql语句
			String sInsert = "insert into grade set username='" + username+ "',score='" + score + "',time='" + time + "'";
			stmt.executeUpdate(sInsert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}
	//查询所有用户
	public Vector getAllUsers()
    {
        //获得数据库连接
        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String stu="student";
        try
        {
            stmt = conn.createStatement();
            //执行SQL语句
            String sQuery ="select * from user where rank='"+stu+"'";
            rs = stmt.executeQuery( sQuery );
            //留着在页面上显示的课程列表
            Vector users = new Vector();
            while ( rs.next() )
            {
                User user = new User();
                user.setRealname(rs.getString(4));
                user.setUsername(rs.getString(1));
                users.add(user);
            }
            return users;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception ex)
            {
            }
        }
    }
	//查找所有用户的成绩信息
	public Vector getUserGrades()
    {
        //获得数据库连接
        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conn.createStatement();
            //执行SQL语句
            String sQuery ="select * from grade ";
            rs = stmt.executeQuery( sQuery );
            //留着在页面上显示的课程列表
            Vector grades = new Vector();
            while ( rs.next() )
            {
                grade gra = new grade();
                gra.setScore(rs.getString(2));
                gra.setTime(rs.getString(3));
                gra.setUsername(rs.getString(1));
                grades.add(gra);
            }
            return grades;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception ex)
            {
            }
        }
    }
    //查找单个用户的成绩信息
    public Vector getAllGrade(String username)
    {
        //获得数据库连接
        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conn.createStatement();
            //执行SQL语句
            String sQuery ="select * from grade where username='"+username+"'";
            rs = stmt.executeQuery( sQuery );
            //留着在页面上显示的课程列表
            Vector grades = new Vector();
            while ( rs.next() )
            {
                grade gra = new grade();
                gra.setScore(rs.getString(2));
                gra.setTime(rs.getString(3));
                gra.setUsername(rs.getString(1));
                grades.add(gra);
            }
            return grades;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception ex)
            {
            }
        }
    }
	// 查找用户
	public boolean selectUser(String username, String role,String password) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// 执行sql语句
			String sQuery = "select * from user " +
					"where username='" + username+ "'" +
				    "and rank='" + role +"'" +
				    "and upassword='"+password+"'";
			rs = stmt.executeQuery(sQuery);
			if (rs.next()) {
				System.out.println("ppp");
				return true;
			} else {

				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}

	// 插入错题库
	public boolean insertError_ex(String username, String body, String head) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// 执行sql语句
			String sQuery = "select * from error_ex where username='"
					+ username + "'and body='" + body + "'";
			String sInsert = "insert into error_ex set username='" + username
					+ "',body='" + body + "',head='" + head + "'";
			rs = stmt.executeQuery(sQuery);
			String bodyThis = null;
			if (rs.next()) {
				return false;
			} else {
				stmt.executeUpdate(sInsert);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}

	// 插入题库
	public boolean insertexercise(String kind, String body, String head)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// 执行SQL语句
			String sQuery = "select * from exercise where kind='" + kind
					+ "'and body='" + body + "' ";
			String sInsert = "insert into exercise set kind='" + kind
					+ "',body='" + body + "',head='" + head + "'";
			rs = stmt.executeQuery(sQuery);
			String bodyThis = null;
			if (rs.next()) {
				return false;

			} else {
				stmt.executeUpdate(sInsert);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}


}
