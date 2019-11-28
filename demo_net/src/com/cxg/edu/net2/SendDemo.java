package com.cxg.edu.net2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	/*
	 * UDP协议发送数据：
	 *    1、创建发送端的Socket对象（DatagramSocket）对象
	 *    2、创建数据，并把数据打包
	 *    3、调用Socket方法发送数据包
	 *    4、释放资源
	 */
	public static void main(String[] args) throws IOException {		
		//创建发送端对象
		DatagramSocket ds = new DatagramSocket();
		//创建数据并发送
		byte[] bys = "hello,UDP".getBytes();		
		int length = bys.length;
		//确定Ip
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 10086;
		//数据打包
		DatagramPacket dp = new DatagramPacket(bys,length,address,port);
		ds.send(dp);			
		//释放资源
		ds.close();

	}

}
