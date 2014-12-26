package com.entityI;

import java.util.Date;

/**
 * Description user实体接口，定义user的属性
 * @author Administrator
 *
 */
public interface userI {
	//用户名username
   public abstract void setUsername(String username);
   public abstract String getUsername();
   //用户密码userpass
   public abstract void setUserpass(String userpass);
   public abstract String getUserpass();
   //用户邮箱
   public abstract void setUseremail(String useremail);
   public abstract String getUseremail();
   //用户注册时间
   public abstract void setRegisterTime(Date registerTime);
   public abstract Date getRegisterTime();
   //用户上次登陆时间
   public abstract void setLastLoginTime(Date lastLoginTime);
   public abstract Date getLastLoginTime();
}
