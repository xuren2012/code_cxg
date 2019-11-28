package com.cxg.edu.net8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {	
    /**
              * 需求：
              *        客户端键盘录入，服务器端输出文本文件
     * @param args
     * @throws IOException 
     * @throws UnknownHostException 
     */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 创建对象
		Socket s = new Socket("127.0.0.1",23456);
		//封装键盘录入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//封装通道内数据
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//接收键盘录入的数据
		String line = null;
		while((line=br.readLine())!=null) {
			if("over".equals(line)) {
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//释放资源
		s.close();

	}

}
