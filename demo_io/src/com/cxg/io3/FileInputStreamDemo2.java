package com.cxg.io3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo2 {
	/**
	 * int read(byte[] b):一次读取一个字节码数组
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 创建对象
		FileInputStream fis = new FileInputStream("fos2.txt");
		// 读取数据
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = fis.read(bys)) != -1) {
			System.out.println(new String(bys, 0, len));
		}
		// 释放资源
		fis.close();
	}

}
