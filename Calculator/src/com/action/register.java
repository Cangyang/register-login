package com.action;

import java.util.Date;

import com.daoI.userDAO;
import com.daoImpl.userDAOImpl;
import com.entityI.userI;
import com.entityImpl.user;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.DateUtils;
/**
 * Description �û�ע����
 * @author Administrator
 *
 */
public class register extends ActionSupport {
    //���岢ʵ�����û�����
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
	 * Ĭ�Ϸ���ע��
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
					addActionMessage("ע��ʧ�ܣ�");
				}
				
			} else{
				addActionMessage("���û����ѱ�ע�ᣡ");
			}
		}
		return forward;
	}
}
