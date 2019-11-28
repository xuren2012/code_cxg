package com.cxg.edu.net5;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatRoom {
	/*
	  * 需求：通过多线程改进聊天程序，可以实现在一个窗口发送和接收数据
	 */
	public static void main(String[] args) throws IOException {
		//创建对象：发送及接收数据
		DatagramSocket dsSend = new DatagramSocket();
		DatagramSocket dsReceive = new DatagramSocket(12306);
		
		//创建接收及发送对象
		SendDemo sd = new SendDemo(dsSend);
		ReceiveDemo rd = new ReceiveDemo(dsReceive);
		//定义多线程
		Thread t1 = new Thread(sd);
		Thread t2 = new Thread(rd);
		//启动线程
		t1.start();
		t2.start();

	}

}
