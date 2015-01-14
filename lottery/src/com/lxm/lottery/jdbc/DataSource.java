package com.lxm.lottery.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataSource {

	private static Connection conn = null;
	private static Statement stat = null;
	
	private static DataSource instance = null;
	
	private DataSource() {
		ConnectionPool.getInstance();
	}
	
	public static DataSource getInstance() {
		if (instance == null) {
			instance = new DataSource();
		}
		return instance;
	}
	
	public ResultSet query(String sql) {
		ResultSet rs = null;
		try {
			rs = generateStatement().executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("[SQL]" + e.getMessage());
		}
		
		if (conn == null) {
			throw new NullPointerException();
		}
		// release the connection back to the pool
		ConnectionPool.release(conn);
		return rs;
	}
	
	public int update(String sql) {
		int result = -1;
		try {
			result = generateStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("[SQL]" + e.getMessage());
		}
		
		if (conn == null) {
			throw new NullPointerException();
		}
		// release the connection back to the pool
		ConnectionPool.release(conn);
		return result;
	}
	
	private Statement generateStatement() {
		try {
			conn = ConnectionPool.getConnection();
			if (conn != null) {
				stat = conn.createStatement();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return stat;
	}
	
	public static void close(ResultSet rs){
		try {
			if(rs != null) 
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
