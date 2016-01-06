package org.github.mervyn.multiThreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: TransferRunnable
  * @Description: TODO
  * @author: mervyn 
  * @date 2016年1月5日 下午10:10:38
  *
  */
public class TransferRunnable implements Runnable {
	private Bank bank;
	private int fromAccount;
	private double maxAccount;
	private int DELAY = 10;
	/**
	  * @Fields logger : TODO（日志对象）
	  */
	private static Logger logger = LoggerFactory.getLogger(TransferRunnable.class);
	
	
	
	/**
	
	  * TransferRunnable类的构造方法. 
	  * <p>Title: TransferRunnable类的构造方法</p>
	  * <p>Description: TransferRunnable类的构造方法</p>
	  * @param bank: 银行
	  * @param fromAccount: 转出钱的账户
	  * @param maxAccount: 每次转出钱的最大值
	  */
	public TransferRunnable(Bank bank, int fromAccount, double maxAccount){
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAccount = maxAccount;
	}
	
	
	
	public void run() {
		try {
			while(true){
				//在银行账户中随机选择一个账户
				int toAccount = (int) (bank.size() * Math.random());
				//随机选定一定的转款金额
				double amount = this.maxAccount * Math.random();
				//转款
				bank.transfer(this.fromAccount, toAccount, amount);
				//当前线程睡眠随机的时间
				Thread.sleep((int)(this.DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
			logger.debug("出现InterruptedException.");
			e.printStackTrace();
		}
	}

}
