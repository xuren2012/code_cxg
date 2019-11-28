package com.cxg.edu.net4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {

	public static void main(String[] args) throws IOException {
		// 创建接收端的Socket对象
		DatagramSocket ds = new DatagramSocket(12345);
		while (true) {
			// 创建容器
			byte[] bys = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bys, bys.length);
			// 接收数据
			ds.receive(dp);
			// 解析数据
			String ip = dp.getAddress().getHostAddress();
			String s = new String(dp.getData(), 0, dp.getLength());
			System.out.println("From:" + ip + "data is:" + s);
		}
		//释放资源
		//接收端应该是一直在线等待接收数据，不能关闭
		//ds.close();

	}

}
