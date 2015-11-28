package org.github.mervyn.java_learn.foundation.constructor;

public class DemoConstructorSequenceOfTwo {
	DemoConstructorSequenceOfOne demoOne1 = new DemoConstructorSequenceOfOne("demoOne1");
	DemoConstructorSequenceOfOne demoOne2 = new DemoConstructorSequenceOfOne("demoOne2");
	static DemoConstructorSequenceOfOne demoOne3 = new DemoConstructorSequenceOfOne("demoOne3");
	
	public DemoConstructorSequenceOfTwo(String str){
		System.out.println("The instance of DemoConstructorSequenceOfTwo : " + str);
	}
}
