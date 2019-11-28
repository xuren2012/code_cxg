package com.cxg.edu.net4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

	public static void main(String[] args) throws IOException {
		/**
		 * 需求： 数据来自键盘录入并自行控制结束 eg:当输入886时线程结束
		 */
		// 创建对象
		DatagramSocket ds = new DatagramSocket();
		// ===========================
		// 封装数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			if ("886".equals(line)) {
				break;
			}
			// 创建数据并打包
			byte[] bys = line.getBytes();
			DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("127.0.0.1"), 12345);

			// ===========================
			// 发送数据
			ds.send(dp);
		}
		//释放资源
		ds.close();

	}

}
