package com.calculator;
/**
 * Description 简单计算器计算业务实现类
 * @author Administrator
 *
 */

import com.opensymphony.xwork2.ActionSupport;
public class Cal extends ActionSupport{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -2973278702673646222L;
	//实例计算器实体类
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
	 * 默认方法为计算器逻辑实现方法
	 */
	public String execute(){
		if(null != cal && !"".equals(cal)){
			//获取计算方法
			String method = cal.getFlag();
			//获取计算参数一
			double num1 = cal.getNum1();
			//获取计算参数二
			double num2 =cal.getNum2();
			//计算结果
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
						addActionMessage("被除数不能为0!");
					}
					break;
				}
				default : 
					addActionMessage("请选择计算方法!");
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
