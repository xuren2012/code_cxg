package com.cxg.io4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
	/**
	 * 需求：
	 *    复制文本文件
	 * 分析：
	 *    数据源：从哪里来
	 *          a.txt-------读取数据---------FileInputStream
	 *    目的地: 到哪里去
	 *          b.txt-------写数据-----------FileOutputStream
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		//封装数据源
		FileInputStream fis = new FileInputStream("a.txt");//确保数据源存在
		//封装目的地
		FileOutputStream fos = new FileOutputStream("b.txt");
		//调用方法，实现功能
		//方式一：一次读取一个字节码！
//		int by = 0;
//		while((by=fis.read())!=-1){
//			fos.write(by);
//		}
		//方式二：一次读取一个字节码数组
		byte[] bys = new byte[1024];
		int len = 0;
		while((len=fis.read(bys))!=-1){//文件没有结束则循环
			fos.write(bys,0,len);
		}
		
		//释放资源
		fos.close();
		fis.close();

	}

}
