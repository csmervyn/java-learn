package org.github.mervyn.java_learn.foundation.constructor;

import static org.junit.Assert.*;

import org.github.mervyn.java_learn.foundation.constructor.DemoConstructorUseSuperOfSon;
import org.junit.Test;

public class DemoConstructorUseSuperTest {

	@Test
	public void test() {
		DemoConstructorUseSuperOfSon demo = new DemoConstructorUseSuperOfSon();
		demo.sonRun();
		/*
		 * 输出结果：Constructor of father
		 *		  Constructor of son
		 *	      son run...
		 * 	      father run...
		 * */
	}

}
