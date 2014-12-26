package com.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.serviceI.DBConnection;

/**
 * Description 由于数据库的关闭操作对于所有实现数据库访问接口的类都是采用一样的方法
 * 所以定义该抽象类实现数据库访问接口的closeConnection方法
 * 至于数据库访问接口的getConnection方法需要具体的数据库实现
 * @author Administrator
 *
 */
public abstract class AbstractConnectionImpl implements DBConnection{
	//实现数据库访问接口的关闭方法
	public void closeConnection(Connection conn){
		try{
			conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//数据库访问接口的连接方法
	public Connection getConnection(){
		return null;
	}
}
