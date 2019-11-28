package com.cxg.edu.net2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
	/*
	 * UDP协议接收数据： 
	 *     A:创建一个接收端的Socket对象
	 *     B:创建一个数据包（容器） 
	 *     C:调用Socket方法接收数据 
	 *     D:解析数据包，并显示在控制台
	 *     E:释放资源
	 */
	public static void main(String[] args) throws IOException {		
		// 创建对象
		DatagramSocket ds = new DatagramSocket(10086);
		// 创建数据包
		byte[] bys = new byte[1024];
		int length = bys.length;
		DatagramPacket dp = new DatagramPacket(bys, length);
		// 接收数据
		ds.receive(dp);
		// 解析数据
		InetAddress address = dp.getAddress();
		String ip = address.getHostAddress();
		byte[] bys2 = dp.getData();		
		int len = bys2.length;
		String s = new String(bys2, 0, len);
		System.out.println(ip + "传输的数据是：" + s);
		// 释放资源
		ds.close();
	}

}
