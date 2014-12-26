package com.calculator;
/**
 * Description �򵥼���������ҵ��ʵ����
 * @author Administrator
 *
 */

import com.opensymphony.xwork2.ActionSupport;
public class Cal extends ActionSupport{
	/**
	 * ���к�
	 */
	private static final long serialVersionUID = -2973278702673646222L;
	//ʵ��������ʵ����
	private calEntity cal;

	/**
	 * @return the cal
	 */
	public calEntity getCal() {
		return cal;
	}

	/**
	 * @param cal the cal to set
	 */
	public void setCal(calEntity cal) {
		this.cal = cal;
	}
	/**
	 * Ĭ�Ϸ���Ϊ�������߼�ʵ�ַ���
	 */
	public String execute(){
		if(null != cal && !"".equals(cal)){
			//��ȡ���㷽��
			String method = cal.getFlag();
			//��ȡ�������һ
			double num1 = cal.getNum1();
			//��ȡ���������
			double num2 =cal.getNum2();
			//������
			double result = 0;
			if(null != method && !"".equals(method)){
				switch(method){
				case "1" : 
					result = num1 + num2;
					break;
				case "2" : 
					result = num1 - num2;
					break;
				case "3" : 
					result = num1 * num2;
					break;
				case "4" : {
					if(0 != num2){
						result = num1 / num2;
					} else {
						addActionMessage("����������Ϊ0!");
					}
					break;
				}
				default : 
					addActionMessage("��ѡ����㷽��!");
					break;
				}
			}
			cal.setNum1(num1);
			cal.setFlag(method);
			cal.setNum2(num2);
			cal.setResult(result);	
		}
		return SUCCESS;
	}
	
}
