package com.action;

import java.util.Date;

import com.daoI.userDAO;
import com.daoImpl.userDAOImpl;
import com.entityI.userI;
import com.entityImpl.user;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.DateUtils;
/**
 * Description 用户注册类
 * @author Administrator
 *
 */
public class register extends ActionSupport {
    //定义并实例化用户对象
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
	/*
	 * 默认方法注册
	 */
	public String execute(){
		String forward = "register";
		userDAO userDao = new userDAOImpl();
		if(null != user.getUsername() && !"".equals(user.getUsername())){
			if(!userDao.isexists(user)){
				Date registerTime = DateUtils.getNowTime();
				user.setRegisterTime(registerTime);
				if(userDao.save(user)){
					forward = "login";
				} else {
					addActionMessage("注册失败！");
				}
				
			} else{
				addActionMessage("该用户名已被注册！");
			}
		}
		return forward;
	}
}
