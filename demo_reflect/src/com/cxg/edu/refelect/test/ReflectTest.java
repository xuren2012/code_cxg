package com.cxg.edu.refelect.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest {
	/**
	 * 需求：给定一个ArrayList<Integer>对象，在这个集合中添加一个字符串数据，如何实现？
	 * 
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 创建集合对象
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(100);
//		array.add("100");
		Class c = array.getClass();
		Method m = c.getMethod("add", Object.class);
		
		//通过反射调用方法完成添加
		m.invoke(array, "hello");   //方法.invoke(对象，参数)
		m.invoke(array, "world");
		System.out.println(array);

	}

}
