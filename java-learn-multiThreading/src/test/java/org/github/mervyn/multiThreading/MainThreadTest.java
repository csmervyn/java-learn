package org.github.mervyn.multiThreading;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: MainThreadTest
  * @Description: 测试主线程
  * @author: mervyn 
  * @date 2016年1月4日 下午4:41:55
  *
  */
public class MainThreadTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testMainThread(测试每个Java程序启动后，虚拟机将自动创建一个主线程)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testMainThread
	  * @Description: 测试每个Java程序启动后，虚拟机将自动创建一个主线程
	  * @param   
	  * @return void
	  * @throws
	  */
	@Test
	public void testMainThread() {
		//获得当前线程的名字(在本测试方法中是主线程)
		String threadName = Thread.currentThread().getName();
		logger.debug("主线程的名字为：" + threadName);
	}

}
