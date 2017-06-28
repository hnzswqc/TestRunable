/*
 * @项目名称: TestRunable
 * @文件名称: Server.java
 * @日期: 2016-12-21 下午04:46:42  
 * @版权: 2016 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Server.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2016-12-21 下午04:46:42   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2016-12-21 下午04:46:42   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Server {

	
	public static void ServerScoket() throws IOException{
		//创建一个服务器，并制定端口为5120
		ServerSocket myServerSocket = new ServerSocket(5120);
		//等待客户端连接
		Socket socket = myServerSocket.accept();
		//链接客户端后，后去客户端输入信息
		InputStream in= socket.getInputStream();
		//通过获取缓冲数据的方式读取文本信息
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		//获取文本信息
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine())!=null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		socket.shutdownInput();
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("收到回复，我是服务器端");
		pw.flush();
		os.close();
		br.close();
		in.close();
		socket.close();
		myServerSocket.close();
	}
	
	
	public static void main(String[] args) {
		while(true){
			try {
				ServerScoket();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
