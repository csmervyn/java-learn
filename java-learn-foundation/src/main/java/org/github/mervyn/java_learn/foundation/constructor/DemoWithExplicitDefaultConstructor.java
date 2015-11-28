package org.github.mervyn.java_learn.foundation.constructor;
//DemoWithExplicitDefaultConstructor中有一个显示的默认构造函数，编译器不会提供隐式的默认构造函数
public class DemoWithExplicitDefaultConstructor {
	private String demoName;

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
	public DemoWithExplicitDefaultConstructor(){
		setDemoName("demoWithExplicitDefaultConstructor");
	}
	
}
