package org.github.mervyn.multiThreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: MyRunnable
  * @Description: 自定义Thread类的对象运行的目标类（创建 java.lang.Runnable接 口的实现类，实现接口中的 run 方法）
  * @author: mervyn 
  * @date 2016年1月4日 下午5:07:14
  *
  */
public class MyRunnable implements Runnable {
	protected static Logger logger = LoggerFactory.getLogger(MyRunnable.class);
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		for(int i = 0; i < 100; i++){
			logger.debug(threadName + ":" + i);
			//System.out.println(threadName + ":" + i);
		}
	}

}
