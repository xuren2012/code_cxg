package com.cxg.io4;

import java.util.Arrays;

public class StringDemo {
	/**
	 * 如何识别是什么时刻把两个字符转换为一个中文的
	 *      计算机中的中文存储分为两个字节：
	 *      第一个字节肯定是负数
	 *      第二个字节常见的也是负数，可能有正数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	
      //String s = "abcde"; //[97, 98, 99, 100, 101]
	  //String s = "我爱你，中国！";//[-26, -120, -111, -25, -120, -79, -28, -67, -96, -17, -68, -116, -28, -72, -83, -27, -101, -67, -17, -68, -127]
		String s = "我";//[-26, -120, -111]
		byte[] bys = s.getBytes();
      System.out.println(Arrays.toString(bys));
	}

}
