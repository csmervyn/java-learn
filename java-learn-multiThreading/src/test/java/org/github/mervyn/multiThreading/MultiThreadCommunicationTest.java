package org.github.mervyn.multiThreading;

import static org.junit.Assert.*;

import org.junit.Test;

/**
  * @ClassName: MultiThreadCommunicationTest
  * @Description: 测试线程的通信
  * @author: mervyn 
  * @date 2016年1月5日 下午3:14:25
  *
  */
public class MultiThreadCommunicationTest {
	public static void main(String[] args) {
		Runnable target = new MultiThreadCommunication();
		
		Thread thread1 = new Thread(target);
		Thread thread2 = new Thread(target);
		
		thread1.start();
		thread2.start();
	}
}
