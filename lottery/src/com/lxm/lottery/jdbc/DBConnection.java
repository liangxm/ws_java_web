package com.lxm.lottery.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sina.sae.util.SaeUserInfo;
 
public class DBConnection {
	
	private static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_lxmlottery";
	private static final String DB_USERNAME = SaeUserInfo.getAccessKey();
	private static final String DB_PASSWORD = SaeUserInfo.getSecretKey();;
	
    public static Connection getConnection() {
        //Properties props = new Properties();
        //InputStream fis = null;
        Connection con = null;
        try {
            //fis=DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
            //props.load(fis);
 
            // load the Driver Class
            Class.forName(DB_DRIVER_CLASS);
 
            // create the connection now
            con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
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