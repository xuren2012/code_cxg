package com.cxg.edu.refelect;

public class ReflectDemo {
	/**
	 *  反射： 就是通过class文件对象，去使用该文件中的成员变量、成员方法、构造方法。
	 *        Person p = new Person(); 
	 *            p.方法；
	 *                     要通过反射使用，首先要得到class文件，也就是得到Class类对象。 
	 *        Class类： 
	 *                                成员变量：Field 
	 *                                构造方法：Contructor
	 *                               成员方法：Method
	 *      获取class文件的三种形式：
	 *      1、Object类的getClass()方法
	 *      2、数据类型的静态属性class
	 *      3、Class类中的静态方法
	 *         public static Class<?> forName(String className)
	 * 如何选择：
	 *     1、自己玩，可任选一种，第二种较方便
	 *     2、开发，则选第三种
	 *                               原因：其需要的是字符串，而不是一个具体的类名。
	 *                                           则可以把这样的字符串配置在配置文件中。
	 * @throws ClassNotFoundException 
	 * 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
        //方式一
		Person p1 = new Person();
		Class c1 = p1.getClass();
		
		Person p2 = new Person();
		Class c2 = p2.getClass();
		
		System.out.println(c1==c2);
		System.out.println(p1==p2);
		
		//方式二
		Class c3 = Person.class;
//		Class c4 = int.class;
//		Class c5 = String.class;
		System.out.println(c2==c3);
		
		//方式三：
		//Class c4 = Class.forName("Person"); //java.lang.ClassNotFoundException   ---类的全限名称
		Class c4 = Class.forName("com.cxg.edu.refelect.Person");
		System.out.println(c4==c1);
	}

}
