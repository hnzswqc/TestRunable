/*
 * @项目名称: TestRunable
 * @文件名称: Test.java
 * @日期: 2017-1-5 下午05:00:43  
 * @版权: 2017 河南中审科技有限公司
 * @开发公司或单位：河南中审科技有限公司研发部
 */
package com.hnzskj.common.tcp;

/**    
 * 项目名称：TestRunable   <br/>
 * 类名称：Test.java   <br/>
 * 类描述：   <br/>
 * 创建人：King   <br/>
 * 创建时间：2017-1-5 下午05:00:43   <br/>
 * 修改人：开发部笔记本   <br/>
 * 修改时间：2017-1-5 下午05:00:43   <br/>
 * 修改备注：    <br/>
 * @version  1.0  
 */
public class Test {

	public static void main(String[] args) {
		String str="348f469c-fe61-4534-82a8-66bf56e398de;4e767634-f328-4424-905d-faca6ebe574e;394c90ff-e4c7-41e2-bdd3-611611611b11;289fdb5f-7db2-4286-9a91-8cd739d9e870;65cecc35-d0fb-4418-8fb9-4faf5b7e9f24;65017a12-53e0-45e7-b411-e8b3bb9fa61b;57fb852c-55b8-46a7-8263-8d7e86a45ac1;b7d91149-0a6b-4d4f-98d4-6d72eb60c55d;c40adffd-0c31-4b8c-ad0f-c84fe691b1f2";
		System.out.println("'"+str.replaceAll(";", "','")+"'");
		System.out.println(Math.atan2(1d, 1d));
		System.out.println(Math.ceil(123.1));
	}
}
