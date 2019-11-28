package com.cxg.edu.net5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo implements Runnable {

	private DatagramSocket ds;

	public ReceiveDemo() {
	}

	public ReceiveDemo(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {
				// 创建容器
				byte[] bys = new byte[1024];
				DatagramPacket dp = new DatagramPacket(bys, bys.length);
				// 接收数据
				ds.receive(dp);
				// 解析数据
				String ip = dp.getAddress().getHostAddress();
				String s = new String(dp.getData(), 0, dp.getLength());
				System.out.println("From:" + ip + ",data is:" + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
