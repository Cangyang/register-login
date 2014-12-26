package com.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Description 继承实现了数据库访问接口的抽象数据库连接类
 * @author Administrator
 *
 */
public class MysqlConnectionImpl extends AbstractConnectionImpl{
	@Override
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(MysqlConnectionConfig.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(MysqlConnectionConfig.url, MysqlConnectionConfig.user, MysqlConnectionConfig.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	@Override
	public void closeConnection(Connection conn){
		super.closeConnection(conn);
	}
}
