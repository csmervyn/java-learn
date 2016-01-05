package org.github.mervyn.multiThreading;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: MyThreadTest
  * @Description: 测试MyThread
  * @author: mervyn 
  * @date 2016年1月4日 下午4:54:23
  *
  */
public class MyThreadTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	  * testThread(测试Thread的子类)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testThread
	  * @Description: 测试Thread的子类
	  * @param   
	  * @return void
	  * @throws
	  */
	@Test
	public void testThread() {
		//1、创建线程对象
		Thread thread = new MyThread();
		//2、调用线程对象的start方法来启动线程
		thread.start();
		
		/*
		 * 主线程也打印0-99之间的数
		 * */
		String threadName = Thread.currentThread().getName();
		for(int i = 0; i < 100; i++){
			logger.debug(threadName + ":" + i);
		}
	}

}
