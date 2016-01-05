package org.github.mervyn.multiThreading;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
  * @ClassName: MyRunnableTest
  * @Description: 测试实现Runnable接口的实现类（Junit本身是不支持普通的多线程测试的,所以才用main方法进行测试）
  * @author: mervyn 
  * @date 2016年1月4日 下午5:12:52
  *
  */
public class MyRunnableTest {
	public static void main(String[] args) {
		//1、创建线程运行的目标类
		Runnable runnable = new MyRunnable();
		//2、创建线程
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		//3、启动线程
		thread1.start();
		thread2.start();
	}

}
