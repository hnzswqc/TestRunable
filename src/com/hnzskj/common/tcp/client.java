/*
 * @项目名称: TestRunable
 * @文件名称: client.java
 * @日期: 2016-12-21 下午04:55:08  
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
import java.net.Socket;
import java.net.UnknownHostException;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：client.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2016-12-21 下午04:55:08   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2016-12-21 下午04:55:08   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class client {

	
	
	public static void clientScoket() throws UnknownHostException, IOException{
		Socket socket = new Socket("localhost",5120);
		OutputStream os =  socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("来自客户端 的socket的数据，你收到了吗？");
		pw.flush();
		socket.shutdownOutput();
		InputStream is =socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer sb =new StringBuffer();
		while((line=br.readLine())!=null){
			sb.append(line);
		}
		System.err.println(sb.toString());
		br.close();
		is.close();
		pw.close();
		socket.close();
	}
	
	public static void main(String[] args) {
		while(true){
			try {
				clientScoket();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
