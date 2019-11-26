package com.cxg.io2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	/**
	 * 如何实现换行： 
	 *           windows： \r\n 
	 *           linux: \n 
	 *           Mac: \r
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 创建对象
		File file = new File("fos2.txt");
		FileOutputStream fos = new FileOutputStream(file, true);
		// 写数据
		for (int i = 0; i < 6; i++) {
           fos.write(("hello 今天是"+i).getBytes());
           fos.write("\r\n".getBytes());
		}
		// 释放资源
	}
}
