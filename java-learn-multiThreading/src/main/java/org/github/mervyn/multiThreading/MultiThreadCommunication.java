package org.github.mervyn.multiThreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: MultiThreadCommunication
  * @Description: 测试多线程通信（以两个线程交替打印a-z之间的字母）
  * @author: mervyn 
  * @date 2016年1月5日 下午2:48:31
  *
  */
public class MultiThreadCommunication implements Runnable {

	protected static Logger logger = LoggerFactory.getLogger(MultiThreadCommunication.class);
	private char letter = 'a';
	public void run() {
		while(letter <= 'z'){
			this.print();
		}
	}
	
	public synchronized void print(){
			//唤醒某个处于等待状态的线程
			notify();
			String threadName = Thread.currentThread().getName();
			logger.debug(threadName + ": " + letter);
			letter++;
			try {
				//让当前线程进入到等待状态
				wait();
			} catch (InterruptedException e) {
				logger.debug("InterruptedException");
				e.printStackTrace();
			}
	}

}
