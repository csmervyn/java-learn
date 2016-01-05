package org.github.mervyn.multiThreading;

import static org.junit.Assert.*;

import org.junit.Test;

/**
  * @ClassName: SynchronizedRunnableTest
  * @Description: 测试线程同步的问题（Junit本身是不支持普通的多线程测试的,所以才用main方法进行测试）
  * @author: mervyn 
  * @date 2016年1月5日 上午10:25:48
  *
  */
public class SynchronizedRunnableTest {

	/**
	  * main(测试多线程同步的问题)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: main
	  * @Description: TODO
	  * @param @param args  
	  * @return void
	  * @throws
	  */
	public static void main(String[] args) {
		//线程运行的目标对象
		Runnable target = new SynchronizedRunnable();
		
		Thread thread1 = new Thread(target);
		thread1.setName("小明");
		Thread thread2 = new Thread(target);
		thread2.setName("小花");
		
		thread1.start();
		thread2.start();
	}

}
