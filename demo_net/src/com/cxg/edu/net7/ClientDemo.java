package com.cxg.edu.net7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
	/*
	 * 需求：同一个窗口中完成发送与接收数据
	 */
	public static void main(String[] args) throws IOException {
		// 创建对象
		Socket s = new Socket("127.0.0.1", 9999);
		// 获取输出流
		OutputStream os = s.getOutputStream();
		os.write("Java TCP! ".getBytes());

		// 获取输入流
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String client = new String(bys, 0, len);
		System.out.println("client:" + client);

		// 释放资源
		s.close();

	}

}
