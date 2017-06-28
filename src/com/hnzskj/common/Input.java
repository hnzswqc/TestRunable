/*
 * @项目名称: TestRunable
 * @文件名称: Input.java
 * @日期: 2016-12-20 下午04:16:43  
 * @版权: 2016 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Input.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2016-12-20 下午04:16:43   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2016-12-20 下午04:16:43   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Input implements Runnable {
	
	Apple apple = null;
	public Input(Apple apple){
		this.apple = apple;
	}



	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int i=0;
		while(true){
			synchronized (apple) {
					if(apple.isFlag()){
							try {
								apple.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
					}
					
					if(i%2==0){
						apple.setName("black apple");
						apple.setColor("black");
					}else{
						apple.setName("红苹果");
						apple.setColor("红");
					}
					apple.setFlag(true);
					System.out.println("放入苹果："+apple.getName()+"，苹果颜色："+apple.getColor());
					apple.notify();
					i++;
				}
			
			}
	}

}
