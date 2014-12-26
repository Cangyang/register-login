package com.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.serviceI.DBConnection;

/**
 * Description �������ݿ�Ĺرղ�����������ʵ�����ݿ���ʽӿڵ��඼�ǲ���һ���ķ���
 * ���Զ���ó�����ʵ�����ݿ���ʽӿڵ�closeConnection����
 * �������ݿ���ʽӿڵ�getConnection������Ҫ��������ݿ�ʵ��
 * @author Administrator
 *
 */
public abstract class AbstractConnectionImpl implements DBConnection{
	//ʵ�����ݿ���ʽӿڵĹرշ���
	public void closeConnection(Connection conn){
		try{
			conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//���ݿ���ʽӿڵ����ӷ���
	public Connection getConnection(){
		return null;
	}
}
