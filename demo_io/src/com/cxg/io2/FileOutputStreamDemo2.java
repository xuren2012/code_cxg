package com.cxg.io2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
	/**
	 * 标准版的输入操作
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			// 创建对象
			File file = new File("fos3.txt");
			// 写数据
			fos.write("java".getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (fos != null) {
				try {
					//释放资源
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
