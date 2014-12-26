package com.factory;

import com.serviceI.DBConnection;

/**
 * Description 数据库连接工厂类
 * @author Administrator
 *
 */
public class DBConnectionFactory {
	private static DBConnection instance;
	//同步锁
	private static Object initLock = new Object();
	public static void getInstance(){
		if(instance == null){
			synchronized(initLock){
				try{
					try{
						Class.forName(DBConnectionConfig.className).newInstance();
					} catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				} catch(InstantiationException e){
					e.printStackTrace();
				} catch(IllegalAccessException e){
					e.printStackTrace();
				}
			}
		}
		
	}
}
