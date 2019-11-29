package com.cxg.edu.refelect4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
	/**
	 * 需求：通过反射获取成员变量并使用
	 * 
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 获取字节码文件对象
     Class c = Class.forName("com.cxg.edu.refelect.Person");
     //获取所有的成员变量
     //Field[] fields = c.getDeclaredFields();
//     Field[] fields = c.getFields();
//     for(Field field:fields) {
//    	 System.out.println(field);
//     }
     //获取单个的成员变量
     //通过无参构造方法创建对象
     Constructor con = c.getConstructor();
     Object obj = con.newInstance();
     //获取address并对其赋值
     Field addressField = c.getField("address");
     //给变量赋值
     addressField.set(obj, "北京市东城区");
     System.out.println(obj);
     
     //获取name并赋值
     Field nameField = c.getDeclaredField("name");
     //暴力访问
     nameField.setAccessible(true);
     nameField.set(obj, "李思思");
     System.out.println(obj);
     
     //获取age并对其赋值----自已完成
	}

}
