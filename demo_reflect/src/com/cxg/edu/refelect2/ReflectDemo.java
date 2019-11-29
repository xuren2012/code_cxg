package com.cxg.edu.refelect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
	/**
	 * 需求：通过反射获取构造方法并使用
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
        //获取构造方法
		//public Constructor<?>[] getConstructors():返回所有公共的构造方法
		//public Constructor<?>[] getDeclaredConstructors():返回所有的构造方法
		
//		Constructor[] cons = c.getConstructors();
//		for(Constructor con:cons) {
//			System.out.println(con);
//		}
		
//		Constructor[] cons = c.getDeclaredConstructors();
//		for(Constructor con:cons) {
//			System.out.println(con);
//		}
		//获取单个的构造方法
		//public Constructor<T> getConstructor(Class<?>... parameterTypes):返回单个的构造方法;
		
		Constructor con = c.getConstructor();//返回的构造方法对象
		//使用Constructor对象表示的构造方法来创建构造方法的类的新实例
		//public T newInstance(Object... initargs)
		Object obj = con.newInstance();
		
		System.out.println(obj);
		
	}

}
