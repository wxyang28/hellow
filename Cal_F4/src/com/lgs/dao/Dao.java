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
	// ��ȡ���ݿ�����
	public Connection getDBConnection() {
		// �����������ݿ�
		try {
			// ����MySQL��JDBC������
			Class.forName("com.mysql.jdbc.Driver");
			// ������ݿ�����
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

	// ����ɼ�
	public boolean insertGrade(String username, String score, String time) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// ִ��sql���
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
	//��ѯ�����û�
	public Vector getAllUsers()
    {
        //������ݿ�����
        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String stu="student";
        try
        {
            stmt = conn.createStatement();
            //ִ��SQL���
            String sQuery ="select * from user where rank='"+stu+"'";
            rs = stmt.executeQuery( sQuery );
            //������ҳ������ʾ�Ŀγ��б�
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
	//���������û��ĳɼ���Ϣ
	public Vector getUserGrades()
    {
        //������ݿ�����
        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conn.createStatement();
            //ִ��SQL���
            String sQuery ="select * from grade ";
            rs = stmt.executeQuery( sQuery );
            //������ҳ������ʾ�Ŀγ��б�
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
    //���ҵ����û��ĳɼ���Ϣ
    public Vector getAllGrade(String username)
    {
        //������ݿ�����
        Connection conn = this.getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conn.createStatement();
            //ִ��SQL���
            String sQuery ="select * from grade where username='"+username+"'";
            rs = stmt.executeQuery( sQuery );
            //������ҳ������ʾ�Ŀγ��б�
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
	// �����û�
	public boolean selectUser(String username, String role,String password) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// ִ��sql���
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

	// ��������
	public boolean insertError_ex(String username, String body, String head) {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// ִ��sql���
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

	// �������
	public boolean insertexercise(String kind, String body, String head)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// ִ��SQL���
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
