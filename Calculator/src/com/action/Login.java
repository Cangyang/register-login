package com.action;

import com.actionSuper.MySuperAction;
import com.daoI.userDAO;
import com.daoImpl.userDAOImpl;
import com.entityI.userI;
import com.entityImpl.user;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.DateUtils;
/**
 * Description 登陆类
 * @author Administrator
 *
 */
public class Login extends MySuperAction{
	//定义用户对象并实例化
	private userI user = new user();
	
	/**
	 * @return the user
	 */
	public userI getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(userI user) {
		this.user = user;
	}
	/**
	 * 默认方法登陆
	 */
	public String execute(){
		String forward = "input";
		userDAO userDao = new userDAOImpl();
		if(null != user.getUsername() && !"".equals(user.getUsername())){
			if(userDao.canLogin(user)){
				user = userDao.query(user.getUsername());
				session.put("username", user.getUsername());
				session.put("lastLoginTime", DateUtils.DateToStr(user.getLastLoginTime()));
				user.setLastLoginTime(DateUtils.getNowTime());
				userDao.update(user);
				forward = "success";
			}else {
				addActionMessage("用户名或密码错误！");
			}
		}
		return forward; 
	}
	/** 功能：退出登录 */
	public String Logout(){		
		session.clear();	
		return "logout";
	}
}
