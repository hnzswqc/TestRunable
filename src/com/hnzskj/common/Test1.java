/*
 * @项目名称: TestRunable
 * @文件名称: Test1.java
 * @日期: 2017-3-30 下午06:44:18  
 * @版权: 2017 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common;

import java.util.ArrayList;
import java.util.List;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Test1.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2017-3-30 下午06:44:18   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2017-3-30 下午06:44:18   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Test1 {

	
	private int a;

	/**
	 * @return the a
	 */
	public int getA() {
		synchronized (this) {
			a++;
		}
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					
				}
			}
		});
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println(new Test1().getA());
				}
			}
		});
		thread2.start();
	}
	
}
