package com.tools;
/*
 * �ַ�������
 */
public class StrUtils {
	/*
	 * ���ⱨ��ָ���쳣����null����תΪ��
	 * ����ʹ���˷���
	 */
	public static <T extends Object> T StrNotNull(T param){
		param = (T)(param == null ? "" : param);
		return param;
	}
}
