package com.cxg.edu.net3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    /*
              * 多次开启服务端：
              *                  出现提示信息
     */
	public static void main(String[] args) throws IOException {
		//创建对象
		DatagramSocket ds = new DatagramSocket(12345);
		//创建容器
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys,bys.length);
		//接收数据
		ds.receive(dp);
		//解析数据
		String ip = dp.getAddress().getHostAddress();
		String s = new String(dp.getData(),0,dp.getLength());
		System.out.println("from:"+ip+" data is :"+s);
		//释放资源
		ds.close();

	}

}
