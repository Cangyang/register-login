package com.daoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.daoI.userDAO;
import com.entityI.userI;
import com.entityImpl.user;
import com.tools.DateUtils;
import com.tools.StrUtils;
import com.core.JDBCUtils;
/**
 * Description user实体数据库操作实现类
 * @author Administrator
 *
 */
public class userDAOImpl implements userDAO{

	@Override
	public boolean isexists(userI user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "select * from user where username = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		try {
			JDBCUtils jdbcUtils = new JDBCUtils();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			if("" != map.get("username") && !map.isEmpty()){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean save(userI user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into user (username,userpass,email,registertime) values (?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getUserpass());
		params.add(user.getUseremail());
		params.add(user.getRegisterTime());
		try {
			JDBCUtils jdbcUtils = new JDBCUtils();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean canLogin(userI user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "select * from user where username = ? and userpass = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getUserpass());
		try {
			JDBCUtils jdbcUtils = new JDBCUtils();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			if("" != map.get("id") && !map.isEmpty()){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(userI user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		userI userOld = new user();
		userOld = this.query(user.getUsername());
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(!"".equals(user.getLastLoginTime()) && null != user.getLastLoginTime() && !userOld.getLastLoginTime().equals(user.getLastLoginTime())){
			sql = "update user set lastlogintime = ? where username=?";
			params.add(user.getLastLoginTime());
			params.add(user.getUsername());
		}
		if(!"".equals(user.getUserpass()) && null != user.getUserpass() && !userOld.getUserpass().equals(user.getUserpass())){
			sql = "update user set userpass = ? where username = ?";
			params.add(user.getUserpass());
			params.add(user.getUsername());
		}
		if(!"".equals(user.getUseremail()) && null != user.getUseremail() && !userOld.getUseremail().equals(user.getUseremail())){
			sql = "update user set email = ? where username = ?";
			params.add(user.getUseremail());
			params.add(user.getUsername());
		}
		JDBCUtils jdbcUtils = new JDBCUtils();
			try {
				flag = jdbcUtils.updateByPreparedStatement(sql, params);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return flag;
	}

	@Override
	public userI query(String username) {
		// TODO Auto-generated method stub
		userI user = new user();
		String sql = "select * from user where username = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		JDBCUtils jdbcUtils = new JDBCUtils();
		try {
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			if("" != map.get("id") && !map.isEmpty()){	
				user.setUseremail(StrUtils.StrNotNull(map.get("email").toString()));
				user.setUsername(map.get("username").toString());
				user.setUserpass(map.get("userpass").toString());
				user.setRegisterTime(DateUtils.format(map.get("registertime")));
				user.setLastLoginTime(DateUtils.format(map.get("lastlogintime")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
