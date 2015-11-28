package org.github.mervyn.java_learn.inheritance.protectedModifier.packageA;
/*
 * 子类和超类在同一个包下面
 * */
public class Cat extends Animal {
	public void catMethod(){
		name = "cat";
		//子类方法，可以访问同一个包中，超类中的protected实例变量（成员变量）。
		age = 18;
		//子类方法，可以访问同一个包中，超类中的protected实例变量（成员变量）。
		sayName();
	}
}
