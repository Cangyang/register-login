package com.entityI;

import java.util.Date;

/**
 * Description userʵ��ӿڣ�����user������
 * @author Administrator
 *
 */
public interface userI {
	//�û���username
   public abstract void setUsername(String username);
   public abstract String getUsername();
   //�û�����userpass
   public abstract void setUserpass(String userpass);
   public abstract String getUserpass();
   //�û�����
   public abstract void setUseremail(String useremail);
   public abstract String getUseremail();
   //�û�ע��ʱ��
   public abstract void setRegisterTime(Date registerTime);
   public abstract Date getRegisterTime();
   //�û��ϴε�½ʱ��
   public abstract void setLastLoginTime(Date lastLoginTime);
   public abstract Date getLastLoginTime();
}
