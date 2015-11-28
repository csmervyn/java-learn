package org.github.mervyn.java_learn.foundation.constructor;

public class DemoConstructorUseSuperOfSon extends DemoConstructorUseSuperOfFather{
	public DemoConstructorUseSuperOfSon(){
		super();
		//可以传参数
		//super("s1");
		//子类构造函数中调用父类的构造函数，super(..)只能放在第一行
		System.out.println("Constructor of son");
		
	}
	public void sonRun(){
		System.out.println("son run...");
		super.fatherRun();
		/*
		 * 子类实例方法调用父类中的实例方法，super.methodName(..)可以放在任意位置
		 * */
	}
}
