package com.cxg.io7;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
    /**
     * String(byte[] byts,String charsetName):通过指定的字符集解码字节数组
     * byte[] getBytes(String charsetName):使用指定的字符集把字符串编码变成字节数组
     * 
     * 编码：
     *      把看的懂的变成看不懂的
     *      String------byte[]
     * 解码：
     *      把看不懂的变成看的懂的
     *      byte[]------String
     * @param args
     * @throws UnsupportedEncodingException 
     */
	public static void main(String[] args) throws UnsupportedEncodingException {
		//发送中文------编码
		String s = "你好！";
		
		//byte[] bys = s.getBytes("GBK");
		//byte[] bys = s.getBytes("UTF-8");
		byte[] bys = s.getBytes("ISO-8859-1");
		System.out.println(Arrays.toString(bys));

	}

}
