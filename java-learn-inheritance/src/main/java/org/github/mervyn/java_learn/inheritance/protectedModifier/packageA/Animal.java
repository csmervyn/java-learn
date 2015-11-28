package org.github.mervyn.java_learn.inheritance.protectedModifier.packageA;

public class Animal {
	public String name;
	protected int age;
	
	protected void sayName(){
		System.out.println("我的名字叫：" + name);
	}
	
	
	protected void crowl(String sound){
		System.out.println("我的叫声是： " + sound);
	}


	
	
}
