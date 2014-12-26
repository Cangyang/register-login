package com.tools;
/*
 * 字符工具类
 */
public class StrUtils {
	/*
	 * 避免报空指针异常，将null对象转为空
	 * 这里使用了泛型
	 */
	public static <T extends Object> T StrNotNull(T param){
		param = (T)(param == null ? "" : param);
		return param;
	}
}
