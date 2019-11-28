package com.cxg.edu.net6;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	/**
	 * TCP协议接收数据： 
	 *      1、创建接收端的Socket对象 
	 *      2、监听客户端的连接，返回一个Socket对象 
	 *      3、获取输入流并解析 
	 *      4、释放资源
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 创建接收端的Socket对象
		ServerSocket ss = new ServerSocket(8888);
		// 监听客户端连接
		Socket s = ss.accept();// 侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞
		// 获取输入流并解析
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String str = new String(bys, 0, len);
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "----------" + str);
		//释放资源
		s.close();
		//ss.close();//这个不能关闭

	}

}
