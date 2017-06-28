/*
 * @项目名称: TestRunable
 * @文件名称: PortUtil.java
 * @日期: 2017-4-5 上午10:12:30  
 * @版权: 2017 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common.bank;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：PortUtil.java   <br/>
 * 类描述： java代码判断端口是否开启  <br/>
 * 创建人：King   <br/>
 * 创建时间：2017-4-5 上午10:12:30   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2017-4-5 上午10:12:30   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class PortUtil {

	/**
	 * 
	 * 方法描述：判断端口是否开启<br/>
	 * 创建人：King   <br/>
	 * 创建时间：2017-4-5 上午10:17:18<br/>         
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/>
	 */
	public static boolean isHostConnectable(String host,int port){
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port));
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		boolean result= PortUtil.isHostConnectable("127.0.0.1", 8080);
		if(result){
			System.out.println("success");
		}else{
			System.out.println("error");
		}
	}
}
