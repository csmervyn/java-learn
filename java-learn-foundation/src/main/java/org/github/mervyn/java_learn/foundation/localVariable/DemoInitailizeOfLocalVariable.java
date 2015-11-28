package org.github.mervyn.java_learn.foundation.localVariable;

public class DemoInitailizeOfLocalVariable {
	public String demoName;
	public void printLocalVariable(){
		System.out.println("成员变量初始化为：" + demoName);
		String localVariable;
		//System.out.println("局部变量初始化为：" + localVariable);
		//编译器会给成员变量在构造类的对象的时候给予初始化，而局部变量编译器没有给予初始化，
		//若在局部变量没有初始化之前，使用该局部变量，编译器将给出The local variable
		//***(变量名) may not been initialized
		//结论：局部变量使用前一定要初始化
	}
}
