/*
 * @项目名称: TestRunable
 * @文件名称: Clent.java
 * @日期: 2017-4-1 下午03:22:40  
 * @版权: 2017 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Clent.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2017-4-1 下午03:22:40   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2017-4-1 下午03:22:40   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Clent {

	
	void run(){
		try {
			Socket client = new Socket("127.0.0.1",20006);
			client.setSoTimeout(10000);
			//获取键盘输入
			BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));
			//获取socket的输入流，用来发送到服务器
			PrintStream out = new PrintStream(client.getOutputStream());
			//获取到sockt的输入流，用来接收从服务器端发送过来的数据
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			boolean flag = true;
			while(flag){
				System.err.println("请输入信息：");
				String str = input.readLine();
				//发送数据到服务器端
				out.print(str);
				if("N".equals(str)){
					flag = false;
				}else{
					String echo = buf.readLine();
					System.err.println(echo);
				}
				input.close();
				if(client!=null){
					client.close();
				}
				 
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Clent().run();
	}
}
