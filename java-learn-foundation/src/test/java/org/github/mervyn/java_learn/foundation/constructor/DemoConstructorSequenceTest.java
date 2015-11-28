package org.github.mervyn.java_learn.foundation.constructor;

import static org.junit.Assert.*;

import org.github.mervyn.java_learn.foundation.constructor.DemoConstructorSequenceOfTwo;
import org.junit.Test;

public class DemoConstructorSequenceTest {
	static DemoConstructorSequenceOfTwo demoTwo3 = new DemoConstructorSequenceOfTwo("demoTwo3");

	@Test
	public  void testConstructorSequence() {
		System.out.println("The test start...");
		DemoConstructorSequenceOfTwo deomTwo1 = new DemoConstructorSequenceOfTwo("demoTwo1");
		System.out.println("<------------------------分割线------------------------->");
		DemoConstructorSequenceOfTwo deomTwo2 = new DemoConstructorSequenceOfTwo("demoTwo2");
		/*
		 * 输出为：
		 * The instance of DemoConstructorSequenceOfOne : demoOne3
		 * The instance of DemoConstructorSequenceOfOne : demoOne2
		 * The instance of DemoConstructorSequenceOfTwo : demoTwo3
		 * The test start...
		 * The instance of DemoConstructorSequenceOfOne : demoOne1
		 * The instance of DemoConstructorSequenceOfOne : demoOne2
		 * The instance of DemoConstructorSequenceOfTwo : demoTwo1
		 * <------------------------分割线------------------------->
		 * The instance of DemoConstructorSequenceOfOne : demoOne1
		 * The instance of DemoConstructorSequenceOfOne : demoOne2
		 * The instance of DemoConstructorSequenceOfTwo : demoTwo2
		 */
	}

}
