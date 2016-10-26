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

	public Connection getDBConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

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


	public boolean insertGrade(String username, String score, String time) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();

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

	public Vector getAllUsers()
    {

        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String stu="student";
        try
        {
            stmt = conn.createStatement();

            String sQuery ="select * from user where rank='"+stu+"'";
            rs = stmt.executeQuery( sQuery );

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

	public Vector getUserGrades()
    {

        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conn.createStatement();

            String sQuery ="select * from grade ";
            rs = stmt.executeQuery( sQuery );

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

    public Vector getAllGrade(String username)
    {

        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conn.createStatement();

            String sQuery ="select * from grade where username='"+username+"'";
            rs = stmt.executeQuery( sQuery );

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

	public boolean selectUser(String username, String role,String password) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sQuery = "select * from user " +
					"where username='" + username+ "'" +
				    "and rank='" + role +"'" +
				    "and upassword='"+password+"'";
			rs = stmt.executeQuery(sQuery);
			if (rs.next()) {
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


	public boolean insertError_ex(String username, String body, String head) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();

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


	public boolean insertexercise(String kind, String body, String head)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();

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
