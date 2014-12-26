package com.factory;

import java.io.IOException;
import java.util.Properties;

/**
 * factory�������ȡ�����ļ��ĸ�����
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
