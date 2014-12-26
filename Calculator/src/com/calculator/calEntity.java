package com.calculator;
/**
 * Description 计算器实体类,包含两个参数、一个运算符号和结果
 * @author Administrator
 */
public class calEntity {
	//简单运算参数一
	private double num1;
	//简单运算参数二
	private double num2;
	//运算符号标识，1 加法，2减法，3乘法，4除法
	private String flag;
	//运算结果
	private double result;
	/**
	 * @return the num1
	 */
	public double getNum1() {
		return num1;
	}
	/**
	 * @param num1 the num1 to set
	 */
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	/**
	 * @return the num2
	 */
	public double getNum2() {
		return num2;
	}
	/**
	 * @param num2 the num2 to set
	 */
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}
	
	
}
