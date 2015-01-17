package com.lxm.lottery.jdbc;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.sina.sae.util.SaeUserInfo;
 
public class DBConnection {
	
	private static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lxmlottery";
	private static final String DB_USERNAME = SaeUserInfo.getAccessKey();
	private static final String DB_PASSWORD = SaeUserInfo.getSecretKey();;
	
/*    public static Connection getConnection() {
        Connection con = null;
        try {
            // load the Driver Class
            Class.forName(DB_DRIVER_CLASS);
 
            // create the connection now
            con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }*/
    
	public static Connection getConnection() {
		Properties props = new Properties();
		InputStream fis = null;
        Connection newConnection = null;
        try {
        	fis=DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
            //fis = new FileInputStream("db.properties");
            props.load(fis);
 
            // load the Driver Class
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
 
            // create the connection now
            newConnection = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
		return newConnection;
	}
    
    public static void close(Connection conn, Statement stat, ResultSet rs) {
			try {
				if(conn!=null)
					conn.close();
				if(stat!=null)
					stat.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
}