package com.cxg.edu.refelect5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	/**
	 * 获取成员方法并使用
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
		//获取所有方法
		//Method[] methods = c.getMethods();//包括父类的构造方法
//		Method[] methods= c.getDeclaredMethods();//获取自己所有的
//        for(Method method:methods) {
//        	System.out.println(method);
//        }
		//得到构造器对象
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		//获取单个的方法并使用
		//获取show（）方法
		Method m1 = c.getMethod("show");
		//如何用？
		m1.invoke(obj);//调用obj对象的m1方法
		System.out.println("====================");
		//调用public String getString(String s,int i)
		Method m2 = c.getMethod("getString", String.class,int.class);
		//调用
		Object objString = m2.invoke(obj, "hello",20);
		System.out.println(objString);
		
		//调用private void function()----自己完成
		Method m3 = c.getDeclaredMethod("function");
		m3.setAccessible(true);
		m3.invoke(obj);
	}

}
