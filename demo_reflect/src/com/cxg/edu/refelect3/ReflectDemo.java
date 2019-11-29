package com.cxg.edu.refelect3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
	/**
	 * 通过反射获取私有的构造方法并使用
	 * 
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获取字节码文件对象
		Class c = Class.forName("com.cxg.edu.refelect.Person");
		//获取私有的构造方法
		Constructor con = c.getDeclaredConstructor(String.class);
		//使用私有的构造方法创建对象
		//暴力访问
		con.setAccessible(true);
		Object obj = con.newInstance("小崔老师");
		System.out.println(obj);

	}

}
