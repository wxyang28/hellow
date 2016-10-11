package com.lgs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	//��ȡ���ݿ�����
	public Connection getDBConnection()
    {
        //�����������ݿ�
        try
        {
            //����MySQL��JDBC������
            Class.forName( "com.mysql.jdbc.Driver" );
            //������ݿ�����
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost/3306?user=root&password=123456" );
            
            return conn;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
	//��������
	public boolean insertCuotiku(String username,String body,String head)
	{  
		    Connection conn=getDBConnection();
		    Statement stmt = null;
	        ResultSet rs = null;
	        try
	        {
	        	stmt=conn.createStatement();
	        	//ִ��sql���
	        	String sQuery="select * from cuoti where username='"+username+"'";
	        	String sInsert="insert into cuoti set username='"+username+"',body='"+body+"',head='"+head+"'";
	        	rs=stmt.executeQuery(sQuery);
	        	String bodyThis = null;
	        	if(rs.next())
	        	{
	        		bodyThis=rs.getString("body");
	        		if(bodyThis==body||bodyThis.equals(body))
	                {
	                	return false;
	                }
	                else
	                {
	                    stmt.executeUpdate(sInsert);
	                    return true;
	                }
	        	}
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
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
			return false;
	}
    //�������
	public boolean insertTiku(String kind,String body,String head) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
        Connection conn=getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = conn.createStatement();
            //ִ��SQL���
            String sQuery = "select * from tiku where kind='" + kind + "' ";
            String sInsert="insert into tiku set kind='"+kind+"',body='"+body+"',head='"+head+"'";
            rs = stmt.executeQuery( sQuery );
            String bodyThis = null;
            if ( rs.next() )
            {
                bodyThis = rs.getString("body");
                if(bodyThis==body||bodyThis.equals(body))
                {
                	return false;
                }
                else
                {
                    stmt.executeUpdate(sInsert);
                    return true;
                }
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
		return false;
	}
	//����ǳ�
	public  String getUserRealname(String sUsername, String sPassword, String sRole) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        //������ݿ�����
        Connection conn=getDBConnection();
        if ( conn == null )
        {
            return null;
        }
        Statement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conn.createStatement();
            //ִ��SQL���
            String sQuery = "select * from user where username='" + sUsername + "' "
                          + "and password='" + sPassword + "' and rank='" + sRole + "' ";
            rs = stmt.executeQuery( sQuery );
            String sRealname = null;
            if ( rs.next() )
            {
                sRealname = rs.getString( "realname" );
            }
            return sRealname;
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
	public boolean insertWrong(String username,String body,String head)
	{
		    Connection conn=getDBConnection();
	        Statement stmt = null;
	        ResultSet rs = null;
	        try
	        {
	            stmt = conn.createStatement();
	            //ִ��SQL���
	            String sQuery = "select * from cuoti where username='" + username + "' ";
	            String sInsert="insert into cuoti set username='"+username+"',body='"+body+"',head='"+head+"'";
	            rs = stmt.executeQuery( sQuery );
	            String bodyThis = null;
	            if ( rs.next() )
	            {
	                bodyThis = rs.getString("body");
	                if(bodyThis==body||bodyThis.equals(body))
	                {
	                	return false;
	                }
	                else
	                {
	                    stmt.executeUpdate(sInsert);
	                    return true;
	                }
	                
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
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
			return false;
	}
}
