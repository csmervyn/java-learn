package org.github.mervyn.java_learn.foundation.constructor;

public class DemoConstructorUseSuperOfFather {
	public DemoConstructorUseSuperOfFather(){
		System.out.println("Constructor of father");
	}
	public DemoConstructorUseSuperOfFather(String s){
		System.out.println("Constructor of father:" + s);
	}
	public void fatherRun(){
		System.out.println("father run...");
	}
}

