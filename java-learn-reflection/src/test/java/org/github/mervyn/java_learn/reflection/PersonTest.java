package org.github.mervyn.java_learn.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class PersonTest {

	/*
	 * 获得Person类实现的所有Interface
	 * */
	@Test
	public void testGetInterfaces() {
		String className = "org.github.mervyn.java_learn.reflection.Person";
		Class<?> c1 = null;
		try {
			c1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获得Person类实现的所有Interface
		Class<?> interfaces[] = c1.getInterfaces();
		for(Class<?> intes : interfaces){
			System.out.println(intes.getName());
		}
	}
	/*
	 * 输出为：org.github.mervyn.java_learn.reflection.MyInterface
	 * */
	
	/*
	 * 获得Person类继承的父类
	 * */
	@Test
	public void testGetFatherClass(){
		String className = "org.github.mervyn.java_learn.reflection.Person";
		Class<?> c1 = null;
		try {
			c1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获得Person类继承的父类
		Class<?> superClass = c1.getSuperclass();
		System.out.println(superClass.getName());
	}
	/*
	 * 输出为：java.lang.Object
	 * */
	
	/*
	 * 调用Person类中的方法
	 * */
	@Test
	public void testMethodInkove(){
		String className = "org.github.mervyn.java_learn.reflection.Person";
		Class<?> c1 = null;
		try {
			c1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用Person中的personMethod方法
		Method method = null;
		try {
			method = c1.getMethod("personMethod");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			method.invoke(c1.newInstance());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 测试输出：我是person的personMethod方法
	 * */
}
