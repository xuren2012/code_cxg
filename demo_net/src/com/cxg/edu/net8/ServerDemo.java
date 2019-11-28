package com.cxg.edu.net8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {
		// 创建对象
		ServerSocket ss = new ServerSocket(23456);
		//监听客户端连接
		Socket s = ss.accept();
		//封装通道内数据
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//封装文本文件
		BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
		String line = null;
		while((line = br.readLine())!=null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//释放资源
		bw.close();
		s.close();
	}

}
