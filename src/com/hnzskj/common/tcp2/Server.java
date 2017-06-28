/*
 * @项目名称: TestRunable
 * @文件名称: Server.java
 * @日期: 2017-4-1 下午03:32:19  
 * @版权: 2017 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common.tcp2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Server.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2017-4-1 下午03:32:19   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2017-4-1 下午03:32:19   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Server {

	void run(){
		try {
			//服务端在20006端口监听客户端请求的tcp链接
			ServerSocket server = new ServerSocket(20006);
			Socket client = null;
			boolean f = true;
			while(f){
				//等待客户端链接，
				client = server.accept();
				System.err.println("与客户端链接成功！");
				new Thread(new ServerThread(client)).start();  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server().run();
	}
	
}
