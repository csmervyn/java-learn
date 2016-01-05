package org.github.mervyn.multiThreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: MyThread
  * @Description: 自定义线程类（创建 java.lang.Thread 类的子类，重写该类的 run方 法）
  * @author: mervyn 
  * @date 2016年1月4日 下午4:44:29
  *
  */
public class MyThread extends Thread {

	protected static Logger logger =  LoggerFactory.getLogger(MyThread.class);
	
	/*
	  * <p>Title: run</p>
	  * <p>Description:自定义的Thread的子类必须重写该方法 </p>
	  * @see java.lang.Thread#run()
	  */
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		for(int i = 0; i < 100; i++){
			logger.debug(threadName + ":" + i);
		}
	}

}
