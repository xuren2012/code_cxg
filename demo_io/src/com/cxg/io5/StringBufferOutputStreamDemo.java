package com.cxg.io5;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StringBufferOutputStreamDemo {
	/**
	 * 带缓冲的类（高效类）：
	 *   写数据：BufferedOutputStream
	 *   读数据：BufferedInputStream
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//创建对象
		File file = new File("a.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//调用方法完成功能
		bos.write("hello java!".getBytes());
		//释放资源
		bos.close();

	}

}
