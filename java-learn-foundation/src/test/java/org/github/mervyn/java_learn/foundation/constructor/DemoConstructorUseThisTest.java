package org.github.mervyn.java_learn.foundation.constructor;

import static org.junit.Assert.*;

import org.github.mervyn.java_learn.foundation.constructor.DemoConstructorUseThis;
import org.junit.Test;
public class DemoConstructorUseThisTest {
	@Test
	public void test() {
		DemoConstructorUseThis demo1 = new DemoConstructorUseThis("demoNoUseThis");
		DemoConstructorUseThis demo2 = new DemoConstructorUseThis();
		System.out.println(demo1.getDemoName() + "---" + demo2.getDemoName());
		/*
		 * 测试输出：demoNoUseThis---useThis
		 */
	}
}
