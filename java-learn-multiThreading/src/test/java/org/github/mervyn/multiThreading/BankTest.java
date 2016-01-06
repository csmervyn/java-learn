package org.github.mervyn.multiThreading;

import static org.junit.Assert.*;

import org.junit.Test;

/**
  * @ClassName: BankTest
  * @Description: 测试线程同步（以银行为例）（junit不支持多线程，所以采用main方法进行测试）
  * @author: mervyn 
  * @date 2016年1月5日 下午10:27:30
  *
  */
public class BankTest {
	public static final int NACCOUNT = 100;
	public static final double INITIAL_BALANCE = 1000;
	
	public static void main(String[] args) {
		//新建一个银行
		Bank bank = new Bank(NACCOUNT, INITIAL_BALANCE);
		int i;
		for(i = 0; i < NACCOUNT; i++){
			Runnable target = new TransferRunnable(bank, i, INITIAL_BALANCE);
			Thread thread = new Thread(target);
			thread.setName("线程" + i);
			thread.start();
		}
		
	}
}
