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
 * Description �ײ����ݿ������
 * @author Administrator
 *
 */
public class JDBCUtils {
	//Ԥ����sql���
	private static PreparedStatement pstmt;
	//sql�����
	private static ResultSet resultSet;
	//���ݿ�����
	private static Connection conn;
	/**
	 * ���ݿ����ӷ���
	 * @return conn
	 * �û�������ĵײ������ʵ�ֵģ�Ҳ�����˽�ʹ�õ�����һ�����ݿ�
	 */
	public static Connection getConnection(){
		DBConnectionFactory.getInstance();
		DBConnection service = new MysqlConnectionImpl();
		conn = service.getConnection();
		return conn;
	}
	/**
	 * ���ݿ�رշ���
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		DBConnection service = new MysqlConnectionImpl();
		conn = service.getConnection();
		service.closeConnection(conn);
	}
	/**
	 * ���ݿ���ɾ�ķ���
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
	 * ��ѯ������¼
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
	 * ��ѯ������¼
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
