package org.github.mervyn.java_learn.foundation.constructor;
/**
 * 实例方法的名字可以与类名同名
 * 
 * */
public class DemoMethodNameSameAsClassName {
	private String demoName;

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
	
	//构造方法
	public DemoMethodNameSameAsClassName(){
		demoName = "Constructor method";
		System.out.println("DemoMethodNameSameAsClassName constructor...");
		System.out.println("demoName is " + getDemoName());
	}
	
	//不是构造方法，而是实例方法。因为其有返回类型void(为了与构造方法区分开。而构造方法与类名相同，所以首字母一般大写。)
	public void DemoMethodNameSameAsClassName(){
		demoName = "Instance method";
		System.out.println("DemoMethodNameSameAsClassName : void");
		System.out.println("demoName is " + getDemoName());
	}
	
	//不是构造方法，而是实例方法。因为其有参数和返回值(为了与构造方法区分开。而构造方法与类名相同，所以首字母一般大写。)
	public String DemoMethodNameSameAsClassName(String title){
		System.out.println("DemoMethodNameSameAsClassName : String");
		System.out.println("demoName is " + getDemoName());
		return getDemoName() + ":" + title;
	}
	
	//普通方法
	public void run(){
		System.out.println("the instance of DemoMethodNameSameAsClassName run...");
	}
}
