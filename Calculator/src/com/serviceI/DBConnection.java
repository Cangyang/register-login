package com.serviceI;
/**
 * Description ���ݿ���ʽӿ�
 * ʵ�ָýӿڵ���ɻ�ø����Ӷ���
 * @author Administrator
 *
 */
import java.sql.Connection;
public interface DBConnection {
	//���ݿ����ӳ��󷽷�
    public abstract Connection getConnection();
    //���ݿ�رճ��󷽷�
    public abstract void closeConnection(Connection conn);

}
