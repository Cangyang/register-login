package com.serviceI;
/**
 * Description 数据库访问接口
 * 实现该接口的类可获得该连接对象
 * @author Administrator
 *
 */
import java.sql.Connection;
public interface DBConnection {
	//数据库连接抽象方法
    public abstract Connection getConnection();
    //数据库关闭抽象方法
    public abstract void closeConnection(Connection conn);

}
