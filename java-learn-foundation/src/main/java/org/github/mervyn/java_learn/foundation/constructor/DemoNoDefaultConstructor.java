package org.github.mervyn.java_learn.foundation.constructor;
//当类中有带参的构造函数时，编译器就不会提供隐式的默认构造函数
public class DemoNoDefaultConstructor {
	private String demoName;

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
	public DemoNoDefaultConstructor(String demoName){
		setDemoName(demoName);
	}
}
