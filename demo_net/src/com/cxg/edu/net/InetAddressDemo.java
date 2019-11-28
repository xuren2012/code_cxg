package com.cxg.edu.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @author YTF
 *
 * @date 2019年11月27日
 */
public class InetAddressDemo {
	/*
	 * 如果一个类中没有构造方法：
	 *   A:成员全部是静态的(Math,Arrays,Collections)
	 *   B:单例模式：(Runtime)
	 *   C:类中有静态方法返回的是该类对象(InetAddress)
	 *       class Demo(){
	 *          private Demo(){}
	 *          public static Demo getXxx(){
	 *             return new Demo();          
	 *          }       
	 *       }
	 *  public static InetAddress getByName(String host):给定主机名/主机Ip地址得到IP地址对象。 
	 */
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getByName("192.168.23.2");
		//获取主机名，IP地址
		String hostName = address.getHostName();
		String hostIP = address.getHostAddress();		
		System.out.println(hostName);
		System.out.println(hostIP);
	}

}
