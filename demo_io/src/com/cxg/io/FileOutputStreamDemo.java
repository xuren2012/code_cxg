package com.cxg.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {
   /**
    * IO流分类：
    *     流向：
    *        输入流    读取数据
    *        输出流    写出数据
    *     数据类型：
    *        字节流：
    *             字节输入流    读取数据   InputStream
    *             字节输出流    写出数据   OutputStream
    *        字符流：
    *             字符输入流    读取数据      Reader
    *             字符输出流     写出数据     Write
    *  注意：
    *     如果没有特殊说明，默认情况下的流分类是按数据类型草划分的
    *     
    *  需求：
    *      向一个文本文件中输入一句话：hello world!
    *  分析：
    *      A:通过分析最好是用字符流来完成，在此先用字节流完成
    *      B:向文件中写入一句话，采用字节流输出
    *      OutputStream 是个抽象类，不能实例化
    *      是向文件中写入一句话---File，而后是字节输出流OutputStream，最后综合使用----FileOutputStream
    *      
    *  注意：
    *     每一种基类的子类都是以父类名作为后缀的
    *     XxxOutputStream
    *     XxxInputStream
    *     XxxReader
    *     XxxWriter
    *    构造方法：
    *      public FileOutputStream(File file)
    *      public FileOutputStream(String name)
    *   字节输出流的操作步骤：
    *      A:创建字节流输出对象
    *      B:写数据
    *      C:释放资源
    *    写数据：
    *       write(byte[] b):写一个字节码数组
    *       write(int b):
    *       write(byte[] b,int off,int len):写一个字节码数组的一部分
    *       
    * 如何实现换行：
    *       windows:\r\n
    *       linux:\n
    *       IOS:\r
    * @throws IOException 
    */
	
	public static void main(String[] args) throws IOException {
		//创建字节流输出对象
		//public FileOutputStream(File file)
		File file = new File("fos.txt");
		OutputStream fos = new FileOutputStream(file,true);
		//写数据
		fos.write("hello io".getBytes());		
		
		//========================
		fos.write(97);
		fos.write(98);
		fos.write('A');
		byte[] bys1 = {97,98,101,102};
		fos.write(bys1,1,3);
		
		//========================
		//释放资源
		fos.close();
	}
}
