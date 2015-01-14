package com.lxm.lottery.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * The Object Pool Pattern by LXM
 * @author lianxiao
 */
public class ConnectionPool {

	private static ArrayList<Connection> connectionPoolList;
	
	private static int instanceCount;
	private static int maxInstances;
	private static Connection poolClass;
	private static ConnectionPool instance;
	
	public static ConnectionPool getInstance(){
		if(instance == null){
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	private ConnectionPool() {
		ConnectionPool.setMaxInstances(10);
		connectionPoolList = new ArrayList<Connection>();
		Connection conn = null;
		// populate connection pool
		for (int i = 0; i <= maxInstances - 1; i++) {
			try {
				conn = ConnectionPool.createConnection();
				connectionPoolList.add(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static int getSize() {
		synchronized (connectionPoolList) {
			return connectionPoolList.size();
		}
	}
	
	private static int getInstanceCount(){
		return instanceCount;
	}
	
	private static int getMaxInstances(){
		return maxInstances;
	}
	
	private static void setInstanceCount(int instanceCount) {
		ConnectionPool.instanceCount = instanceCount;
	}
	
	private static void setMaxInstances(int maxInstances) {
		ConnectionPool.maxInstances = maxInstances;
	}
	
	public static Connection getConnection() throws SQLException {
		synchronized (connectionPoolList) {
			Connection thisConnection = removeObject();
			
			if(thisConnection != null) {
				return thisConnection;
			}
			if(getInstanceCount() < getMaxInstances()) {
				// pool is empty
				// allocate a new object, thus increasing the size of the pool
				ConnectionPool.setMaxInstances(maxInstances++);
				return createConnection();
			}
			return null;
		}
	}
	
	private static Connection createConnection() throws SQLException {
		Properties props = new Properties();
		FileInputStream fis = null;
        Connection newConnection = null;
        try {
            fis = new FileInputStream("db.properties");
            props.load(fis);
 
            // load the Driver Class
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
 
            // create the connection now
            newConnection = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		ConnectionPool.setInstanceCount(instanceCount + 1);
		return newConnection;
	}
	
	private static Connection removeObject() {
		if (connectionPoolList.size() > 0) {
			poolClass = connectionPoolList.get(ConnectionPool.getSize());
			connectionPoolList.remove(ConnectionPool.getSize() - 1);
			ConnectionPool.setInstanceCount(instanceCount - 1);
			return poolClass;
		}
		return null;
	}
	
	public static void release(Connection conn) {
		if (conn == null) {
			throw new NullPointerException();
		}
		if (poolClass != conn) {
			String actualClassName = conn.getClass().getName();
			throw new ArrayStoreException(actualClassName);
		} // if is instance
		connectionPoolList.add(conn);
		ConnectionPool.setInstanceCount(instanceCount + 1);
	}
}
