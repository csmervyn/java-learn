package org.github.mervyn.java_learn.foundation.constructor;

public class DemoConstructorUseThis {
	private String demoName;
	
	public String getDemoName() {
		return demoName;
	}
	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
	public DemoConstructorUseThis (String demoName){
		this.demoName = demoName;
	}
	public DemoConstructorUseThis (){
		this("useThis");
	}
}
