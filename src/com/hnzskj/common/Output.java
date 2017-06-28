/*
 * @项目名称: TestRunable
 * @文件名称: Output.java
 * @日期: 2016-12-20 下午04:19:57  
 * @版权: 2016 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Output.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2016-12-20 下午04:19:57   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2016-12-20 下午04:19:57   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Output implements Runnable {

	Apple apple = null;
	
	public Output(Apple apple){
		this.apple = apple;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true){
			synchronized (apple) {
				if(!apple.isFlag()){
 					try {
						apple.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("拿出苹果，苹果名称："+apple.getName()+"，苹果颜色："+apple.getColor());
				apple.setFlag(false);
				apple.notify();
			}
		}
	}

}
