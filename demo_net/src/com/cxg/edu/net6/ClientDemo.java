package com.cxg.edu.net6;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
    /*
     * 
     * TCP协议发送数据：
     *   1、创建发送端的Socket对象
              *                            这一步如果成功，则表明连接已经建立。
     *   2、获取输入流、写数据
     *   3、释放资源
     */
	public static void main(String[] args) throws IOException {
		// 创建对象
		Socket s = new Socket("127.0.0.1",8888);
		//发送数据
		OutputStream os = s.getOutputStream();
		os.write("hello TCP !".getBytes());
		//释放资源
		s.close();

	}

}
