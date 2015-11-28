package org.github.mervyn.java_learn.reflection;

public class Person implements MyInterface {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void interfaceMethod() {
		System.out.println("我是person实现MyInterface的interfaceMethod方法");
	}
	
	public void personMethod(){
		System.out.println("我是person的personMethod方法");
	}

}
