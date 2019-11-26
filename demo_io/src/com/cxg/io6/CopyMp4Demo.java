package com.cxg.io6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMp4Demo {
     /**
      * 测试复制文件时不是的方法对应的时间：
      * 需求：
      *     把e:\\demo\\aaa.mp4复制到当前目录下
      * 分析：
      *    字节流四种方式复制文件：
      *         基本的字节流一次读写一个字节
      *         基本的字节流一次读写一个字节码数组
      *         高效的字节流一次读写一个字节
      *         高效的字节流一次读写一个字节码数组
      *    字符流四种方式复制文件：
      *         基本的字符流一次读写一个字符
      *         基本的字符流一次读写一个字符数组
      *         高效的字符流一次读写一个字符
      *         高效的字符流一次读写一个字符数组
      *         
      * @param args
     * @throws IOException 
      */
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		//基本的字节流一次读写一个字节
		method("e:\\demo\\aaa.mp4","copy.mp4");
		//高效的字节流一次读取一个字节码数组
		method2("e:\\demo\\aaa.mp4","copy.mp4");
		long end = System.currentTimeMillis();
		System.out.println("共用时："+(end-start)+"毫秒。");
	}
	//基本的字节流一次读写一个字节
	private static void method2(String srcString, String destString) throws IOException {
		//创建对象
		FileInputStream fis = new FileInputStream(srcString);
		FileOutputStream fos = new FileOutputStream(destString);
		//调用方法完成功能
		int by = 0;
		while((by=fis.read())!=-1){
			fos.write(by);
		}
		//释放资源
		fos.close();
		fis.close();
	}
	//高效的字节流一次读取一个字节码数组
	private static void method(String srcString, String destString) throws IOException {
		//创建对象
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));
		//调用方法完成功能
		byte[] bys = new byte[1024];
		int len = 0;
		while((len=bis.read(bys))!=-1){
			bos.write(bys);
		}
		//释放资源
		bos.close();
		bis.close();
		
	}

}
