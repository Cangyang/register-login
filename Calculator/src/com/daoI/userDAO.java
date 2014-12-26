package com.daoI;
import com.entityI.userI;
import com.entityImpl.user;
/**
 * 实体类user的数据库操作接口
 * @author Administrator
 *
 */
public interface userDAO {
	//数据库查询是否存在用户实体
	public abstract boolean isexists(userI user);
	//数据库保存用户实体
	public abstract boolean save(userI user);
	//数据库查询登陆实体是否存在
	public abstract boolean canLogin(userI user);
	//数据库根据用户名查询整个实体
	public abstract userI query(String username);
	//数据库更新实体属性
	public abstract boolean update(userI user);
}
