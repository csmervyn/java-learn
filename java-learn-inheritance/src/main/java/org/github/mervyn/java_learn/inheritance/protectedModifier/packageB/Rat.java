package org.github.mervyn.java_learn.inheritance.protectedModifier.packageB;

import org.github.mervyn.java_learn.inheritance.protectedModifier.packageA.Animal;

public class Rat extends Animal {
	public void ratMethod(){
		//在不同的包中，子类可以访问超类中的protected实例变量（成员变量）
		age = 19;
		//在不同的包中，子类可以访问超类中的protected的方法
		sayName();
	}
}
