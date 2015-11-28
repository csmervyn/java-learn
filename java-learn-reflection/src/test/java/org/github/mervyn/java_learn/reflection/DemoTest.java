package org.github.mervyn.java_learn.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {

	
	@Test
	public void testGetClassInstance1() {
		Demo demo = new Demo();
		//方法1：通过Object类中的getClass方法，获得Class类的实例
		Class c1 = demo.getClass();
		//Class的getName方法将返回类的名字(包含完整的包名)。
		Assert.assertEquals("org.github.mervyn.java_learn.reflection.Demo", c1.getName());
	}
    /*
     * 是否通过测试：通过测试。
     * */
	
	@Test
	public void testGetClassInstance2(){
		Class<?> c1 = null;
		String className = "org.github.mervyn.java_learn.reflection.Demo";
		//方法2：一般尽量采取这种方法
		try {
			//调用Class类的静态方法forName获得类名对应的Class对象
			c1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(className, c1.getName());	
	}
	/*
     * 是否通过测试：通过测试。
     * */
	
	@Test
	public void testGetClassInstance3(){
		Class<?> c1 = null;
		c1 = Demo.class;
		Assert.assertEquals("org.github.mervyn.java_learn.reflection.Demo", c1.getName());
	}
	 /*
     * 是否通过测试：通过测试。
     * */
	
	@Test
	public void testNewInstance1(){
		String className = "org.github.mervyn.java_learn.reflection.Demo";
		Class<?> c1 = null;
		try {
			c1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Demo demo = null;
		try {
			demo = (Demo) c1.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo.setDemoName("newInstance1");
		demo.setAge(1);
		System.out.println(demo.toString());
	}
	/*
	 * 测试输出结果：Demo [demoName=newInstance1, age=1]
	 * */
	
	@Test
	public void testNewInstance2(){
		String className = "org.github.mervyn.java_learn.reflection.Demo";
		Class<?> c1 = null;
		try {
			c1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Demo demo1 = null;
		Demo demo2 = null;
		Demo demo3 = null;
		printConstructors(c1);
		printMethods(c1);
		printFields(c1);
		
		//方法1：不知道明确知道构造函数的参数的情况下。通过调用Class对象的getConstructors()方法，返回Constructor数组包含每一个声明为公有的构造方法。
		Constructor<?>[] constructors = c1.getConstructors();
		try {
			//注意：必须根据construtctors数组元素接受实际的参数类型的顺序，传递参数。比如，
			//给constructors[0].newInstance("demo1",2)这样的参数是不行的，因为
			//constructors[0]的newInstance()方法只能接受String的参数
			
			demo1 = (Demo) constructors[0].newInstance("demo1");
			demo2 = (Demo) constructors[1].newInstance("demo2",2);
			demo3 = (Demo) constructors[2].newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(demo1);
		System.out.println(demo2);
		System.out.println(demo3);
		
		Demo demo4 = null;
		Constructor<?> constructor = null;
		try {
			//方法2：如果你知道你要访问的的构造方法参数类型，你可以用下面的方法获得指定的构造方法。
			constructor = c1.getConstructor(String.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			demo4 = (Demo) constructor.newInstance("demo4");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(demo4);	
		
	}
	/*
	 * 测试输出为：
	 * constructor's number:3
	   public org.github.mervyn.java_learn.reflection.Demo(java.lang.String);
	   public org.github.mervyn.java_learn.reflection.Demo(java.lang.String, int);
	   public org.github.mervyn.java_learn.reflection.Demo();
	   Demo [demoName=demo1, age=0]
	   Demo [demoName=demo2, age=2]
	   Demo [demoName=null, age=0]
	   Demo [demoName=demo4, age=0]

	 * */
	
	/**
	 * print all constructor of a class
	 * */
	public static void printConstructors(Class c1){
		Constructor<?>[] constructors = c1.getConstructors();
		System.out.println("constructor's number:" + constructors.length);
		for(Constructor<?> constructor : constructors){
			String name = constructor.getName();
			System.out.print(" ");
			String modifies = Modifier.toString(constructor.getModifiers());
			if(modifies.length() > 0){
				System.out.print(modifies + " ");
			}
			System.out.print(name + "(");
			//print parameter type
			Class<?>[] paramTypes = constructor.getParameterTypes();
			for(int j = 0;j < paramTypes.length;j++){
				if(j > 0){
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}		
	}
	
	/*
	 * print all method of a class
	 * */
	public static void printMethods(Class c1){
		Method [] methods = c1.getMethods();
		for(Method method : methods){
			String methodName = method.getName();
			System.out.print(" ");
			String modifies = Modifier.toString(c1.getModifiers());
			if(modifies.length() > 0){
				System.out.print(modifies + " ");
			}
			System.out.print(methodName + "(");
			Class<?> [] paramTypes = method.getParameterTypes();
			for(int j = 0;j < paramTypes.length;j++){
				if(j > 0){
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/*
	 * print all fields of a class
	 * */
	public static void printFields(Class c1){
		Field[] fields = c1.getDeclaredFields();
		for(Field field : fields){
			Class type = field.getType();
			String fieldName = field.getName();
			System.out.print(" ");
			String modifies = Modifier.toString(field.getModifiers());
			if(modifies.length() > 0){
				System.out.print(modifies + " ");
			}
			System.out.println(type.getName() + " " + fieldName + ";");
		}
	}

}
