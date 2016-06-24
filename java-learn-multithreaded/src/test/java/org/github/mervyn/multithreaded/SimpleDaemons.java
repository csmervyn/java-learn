package org.github.mervyn.multithreaded;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleDaemons implements Runnable {
	private  Logger logger = LoggerFactory.getLogger(this.getClass());
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + "" + this);
			} 
		} catch (Exception e) {
			logger.debug("sleep() interrupted");
		}
	}
	
	public static void main(String[] args){
		for(int i = 0; i < 10; i++ ){
			Thread thread = new Thread(new SimpleDaemons());
			thread.setDaemon(true);
			thread.start();
		}
		System.out.println("All daemons start");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("sleep()被打断");
			e.printStackTrace();
		}
	}

}
