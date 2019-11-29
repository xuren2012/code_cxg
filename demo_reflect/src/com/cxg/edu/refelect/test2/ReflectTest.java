package com.cxg.edu.refelect.test2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
	/**
	 * 通过配置文件运行类中的方法 
	 *       反射： 需要有配置文件配合使用。 
	 *              用class.txt代替 
	 *                   并且确认有两个键：className,methodName
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 反射完成
		// 加载键值对数据
		Properties prop = new Properties();
		FileReader fr = new FileReader("class.txt");
		prop.load(fr);
		fr.close();
		// 获取数据
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");

		// 反射
		Class c = Class.forName(className);

		Constructor con = c.getConstructor();
		Object obj = con.newInstance();

		// 调用方法
		Method m = c.getMethod(methodName);
		m.invoke(obj);
	}

}
