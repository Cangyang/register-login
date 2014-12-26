package com.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description ���ڴ�������
 * @author Administrator
 *
 */
public class DateUtils {
	/*
	 * ����ϵͳ��ǰʱ��
	 */
	public static Date getNowTime(){
		Date now = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			now = dateFormat.parse(dateFormat.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return now;
	}
	
	public static Date format(Object object){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			if(null != object && !"".equals(object)){
				date = dateFormat.parse(object.toString());
			} else {
				date = getNowTime();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	public static String DateToStr(Date d) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		String date = null;
		date = dateFormat.format(d);
		return date;
	}
}
