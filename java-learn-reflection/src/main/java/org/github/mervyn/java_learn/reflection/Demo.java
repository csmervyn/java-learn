package org.github.mervyn.java_learn.reflection;

public class Demo {
	private String demoName;
	private int age;
	
	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//无参构造器
	public Demo(){}
	
	//有一个参数的构造器
	public Demo(String demoName){
		this.demoName = demoName;
	}
	
	//有两个参数的构造器
	public Demo(String demoName,int age){
		this.demoName = demoName;
		this.age = age;
	}

	public void demoMethod(){
		System.out.println("我是demo的实例方法。");
	}

	@Override
	public String toString() {
		return "Demo [demoName=" + demoName + ", age=" + age + "]";
	}
	
	
	
	
}
