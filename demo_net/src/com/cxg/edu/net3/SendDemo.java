package com.cxg.edu.net3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendDemo {
     /*
                 * 简化版UDP发送接收数据
      */
	public static void main(String[] args) throws IOException {
		//创建对象
		DatagramSocket ds = new DatagramSocket();
		//创建数据并打包
		byte[] bys = "hello,world".getBytes();
		DatagramPacket dp = new DatagramPacket(bys,bys.length,InetAddress.getByName("127.0.0.1"),12345);
		//发送数据
		ds.send(dp);
		//释放资源
		ds.close();

	}

}
