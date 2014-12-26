package com.serviceImpl;

import java.io.IOException;
import java.util.Properties;

/**
 * Description Mysql数据库配置文件读取类
 * @author Administrator
 *
 */
public class MysqlConnectionConfig {
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(MysqlConnectionConfig.class.getResourceAsStream("/com/MysqlConnectionConfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String driver = prop.getProperty("driver");
	public static String url = prop.getProperty("url");
	public static String user = prop.getProperty("user");
	public static String password = prop.getProperty("password");
}
