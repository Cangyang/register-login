package com.daoI;
import com.entityI.userI;
import com.entityImpl.user;
/**
 * ʵ����user�����ݿ�����ӿ�
 * @author Administrator
 *
 */
public interface userDAO {
	//���ݿ��ѯ�Ƿ�����û�ʵ��
	public abstract boolean isexists(userI user);
	//���ݿⱣ���û�ʵ��
	public abstract boolean save(userI user);
	//���ݿ��ѯ��½ʵ���Ƿ����
	public abstract boolean canLogin(userI user);
	//���ݿ�����û�����ѯ����ʵ��
	public abstract userI query(String username);
	//���ݿ����ʵ������
	public abstract boolean update(userI user);
}
