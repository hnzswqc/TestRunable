/*
 * @项目名称: TestRunable
 * @文件名称: SereverThread.java
 * @日期: 2017-4-1 下午03:35:57  
 * @版权: 2017 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.hnzskj.common.tcp.client;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：SereverThread.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2017-4-1 下午03:35:57   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2017-4-1 下午03:35:57   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class ServerThread implements Runnable {
	private Socket client = null;
	ServerThread(Socket client){
		this.client = client;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			//获取socket的输出流，用来向客户端发送数据
			PrintStream out = new PrintStream(client.getOutputStream());
			//获取socket的输入流，用来接收从客户端发送过来的数据
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			boolean flag = true;
			while(flag){
				//接收从客户端发送过来的数据
				//通过获取缓冲数据的方式读取文本信息
				//获取文本信息
				String line;
				StringBuffer sb = new StringBuffer();
				while ((line = br.readLine())!=null) {
					sb.append(line);
				}
				System.out.println(sb.toString());
				PrintWriter pw = new PrintWriter(out);
				String str = sb.toString();
				if(null!=str&&!"".equals(str)){
					if("N".equals(str)){
						flag = false;
					}else{
						out.print(new Date().getTime()+"~~~~~~~~~~~~each:"+str);
					}
				}else{
					flag = false;
				}
			}
			out.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
