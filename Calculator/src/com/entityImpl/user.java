package com.entityImpl;
import java.util.Date;

/**
 * Description userʵ��ʵ����
 * @author Administrator
 *
 */
import com.entityI.userI;
public class user implements userI{
	//�û���
	private String username;
	//�û�����
	private String userpass;
	//�û�����
	private String useremail;
	//�û�ע��ʱ��
	private Date registerTime;
	//�û���¼ʱ��
	private Date lastLoginTime;
	/**
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the userpass
	 */
	@Override
	public String getUserpass() {
		return userpass;
	}
	/**
	 * @param userpass the userpass to set
	 */
	@Override
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	/**
	 * @return the useremail
	 */
	@Override
	public String getUseremail() {
		return useremail;
	}
	/**
	 * @param useremail the useremail to set
	 */
	@Override
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	/**
	 * @return the registerTime
	 */
	@Override
	public Date getRegisterTime() {
		return registerTime;
	}
	/**
	 * @param registerTime the registerTime to set
	 */
	@Override
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * @return the lastLoginTime
	 */
	@Override
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	@Override
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}
