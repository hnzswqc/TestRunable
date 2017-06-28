/*
 * @项目名称: TestRunable
 * @文件名称: Apple.java
 * @日期: 2016-12-20 下午04:12:56  
 * @版权: 2016 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Apple.java   <br/>
 * 类描述：苹果实体类   <br/>
 * 创建人：King   <br/>
 * 创建时间：2016-12-20 下午04:12:56   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2016-12-20 下午04:12:56   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Apple {

	public Apple(){}
	public Apple(String name,String color){
		this.name = name;
		this.color = color;
	}
	
	public Apple(String name,String color,boolean flag){
		this.name = name;
		this.color = color;
		this.flag = flag;
	}
	
	private String name ;
	
	private String color;
	
	private boolean flag = false;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
	public static void main(String[] args) {
			Apple apple = new Apple();
			Input input = new Input(apple);
			Output output = new Output(apple);
			Thread t1 = new Thread(input);
			Thread t2 = new Thread(output);
			t1.start();
			t2.start();
		
	}
	
}



