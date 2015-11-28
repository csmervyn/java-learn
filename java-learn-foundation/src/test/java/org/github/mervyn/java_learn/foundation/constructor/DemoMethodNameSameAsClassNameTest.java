package org.github.mervyn.java_learn.foundation.constructor;

import static org.junit.Assert.*;

import org.github.mervyn.java_learn.foundation.constructor.DemoMethodNameSameAsClassName;
import org.junit.Test;

public class DemoMethodNameSameAsClassNameTest {

	@Test
	public void testRun() {
		DemoMethodNameSameAsClassName demo = new DemoMethodNameSameAsClassName();
		demo.run();
		/*
		 * 测试输出：DemoMethodNameSameAsClassName constructor...
				  demoName is Constructor method
				  the instance of DemoMethodNameSameAsClassName run...
				  
		 * */
	}
	
	@Test
	public void testDemoMethodNameSameAsClassName(){
		DemoMethodNameSameAsClassName demo = new DemoMethodNameSameAsClassName();
		demo.DemoMethodNameSameAsClassName();
		System.out.println(demo.DemoMethodNameSameAsClassName("test"));
		/*
		 * 测试输出：DemoMethodNameSameAsClassName constructor...
				  demoName is Constructor method
				  DemoMethodNameSameAsClassName : void
				  demoName is Instance method
				  DemoMethodNameSameAsClassName : String
				  demoName is Instance method
				  Instance method:test
				  说明：实例方法可以与类名重名
		 * */
	}
	
	

}
