package org.github.mervyn.java_learn.inheritance.protectedModifier.packageB;

import static org.junit.Assert.*;

import org.github.mervyn.java_learn.inheritance.protectedModifier.packageA.Animal;
import org.github.mervyn.java_learn.inheritance.protectedModifier.packageA.Cat;
import org.junit.Test;

public class ProtectedModifierInDifferentPackageTest {

	@Test
	public void test() {
		Animal animal = new Animal();
		//不同包中，不能调用protected的实例变量和方法
		//animal.
	}

	@Test
	public void testDifferentPackage(){
		//不同包中，子类的实例不能调用超类的protected的实例变量（成员变量）,方法
		Rat rat = new Rat();
		//rat.age = 12;
		//rat.crowl("吱吱吱...");
		Cat cat = new Cat();
		
	}
}
