package org.github.mervyn.java_learn.inheritance.protectedModifier.packageA;

import static org.junit.Assert.*;

import org.github.mervyn.java_learn.inheritance.protectedModifier.packageB.Rat;
import org.junit.Test;

public class ProtectedModifierInOnePackageTest {

	@Test
	public void test() {
		Cat cat = new Cat();
		cat.catMethod();
		
		//同一包中，子类的实例调用超类的protect的实例变量（成员变量），方法
		cat.age = 11;
		cat.crowl("喵喵喵...");
	}
	
	@Test
	public void testOnePackage(){
		Animal animal = new Animal();
		//同一个包中，没有继承Animal类的其它类可以调用
		animal.crowl("@@@@@@@(不是动物，所以它说的语言没有听过)");
	}
	
	

}
