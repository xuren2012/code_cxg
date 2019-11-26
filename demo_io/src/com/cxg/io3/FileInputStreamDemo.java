package com.cxg.io3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
	/**
	 * 字节输入流的操作步骤： 
	 * A:创建字节码输入流对象 
	 * B:调用read（）方法读取数据，并且显示在控制台
	 * C:释放资源 读取数据的方式： int
	 * read():一次读取一个字节 
	 * int read(byte[] b):一次读取一个字节码数组
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 创建字节码输入流对象
		FileInputStream fis = new FileInputStream("fos2.txt");
		// 调用read()方法读取数据
		int by = 0;
		while ((by = fis.read()) != -1) {// 文件没有结束则继续
			System.out.print((char)by);
		}
		// 释放资源
		fis.close();
	}

}
