package com.factory;

import java.io.IOException;
import java.util.Properties;

/**
 * factory工厂类读取配置文件的辅助类
 * @author Administrator
 *
 */
public class DBConnectionConfig {
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(DBConnectionConfig.class.getResourceAsStream("/com/DBConnectionConfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String className = prop.getProperty("className");
}
