package com.cxg.edu.net5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo implements Runnable {

	private DatagramSocket ds;

	public SendDemo() {
	}	

	public SendDemo(DatagramSocket ds) {
		
		this.ds = ds;
	}


	@Override
	public void run() {
		try {
			//封装键盘录入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while((line=br.readLine())!=null) {
				if("886".equals(line)) {
					break;
				}
				//创建数据并打包
				byte[] bys = line.getBytes();
				DatagramPacket dp = new DatagramPacket(bys,bys.length,InetAddress.getByName("127.0.0.1"),12306);
				//发送数据
				ds.send(dp);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			//ds.close();
		}
		
	}

}
