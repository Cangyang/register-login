package com.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.factory.DBConnectionFactory;
import com.serviceI.DBConnection;
import com.serviceImpl.MysqlConnectionImpl;

/**
 * Description 底层数据库操作类
 * @author Administrator
 *
 */
public class JDBCUtils {
	//预编译sql语句
	private static PreparedStatement pstmt;
	//sql结果集
	private static ResultSet resultSet;
	//数据库连接
	private static Connection conn;
	/**
	 * 数据库连接方法
	 * @return conn
	 * 用户无需关心底层是如何实现的，也无需了解使用的是哪一种数据库
	 */
	public static Connection getConnection(){
		DBConnectionFactory.getInstance();
		DBConnection service = new MysqlConnectionImpl();
		conn = service.getConnection();
		return conn;
	}
	/**
	 * 数据库关闭方法
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		DBConnection service = new MysqlConnectionImpl();
		conn = service.getConnection();
		service.closeConnection(conn);
	}
	/**
	 * 数据库增删改方法
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean updateByPreparedStatement(String sql, List<Object> params) throws SQLException{
		getConnection();
		boolean flag = false;
		int result = -1;
		pstmt = conn.prepareStatement(sql);
		int index = 1;
		if(null != params && !params.isEmpty()){
			for(int i = 0; i < params.size(); i ++){
				pstmt.setObject(index++, params.get(i));
			}
		}
		result = pstmt.executeUpdate(); 
		flag = result > 0 ? true : false;
		closeConnection(conn);
		return flag;
	}
	/**
	 * 查询单条记录
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object>findSimpleResult(String sql, List<Object>params) throws SQLException{
		getConnection();
		Map<String, Object> map = new HashMap<String, Object>();
		int index = 1;
		pstmt = conn.prepareStatement(sql);
		if(null != params && !params.isEmpty()){
			for(int i = 0; i < params.size(); i ++){
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while(resultSet.next()){
			for(int i = 0; i < col_len; i ++){
				String cols_name = metaData.getColumnName(i+1);
				Object cols_value = resultSet.getObject(cols_name);
				if(cols_value == null){
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
		}
		closeConnection(conn);
		return map;
	}
	/**
	 * 查询多条记录
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findModeResult(String sql, List<Object>params) throws SQLException{
		getConnection();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = conn.prepareStatement(sql);
		if(null != params && !params.isEmpty()){
			for (int i = 0; i < params.size(); i ++){
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while(resultSet.next()){
			Map<String, Object>  map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i ++){
				String cols_name = metaData.getColumnName(i+1);
				Object cols_value = resultSet.getObject(cols_name);
				if(cols_value == null){
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		closeConnection(conn);
		return list;
	}
}
