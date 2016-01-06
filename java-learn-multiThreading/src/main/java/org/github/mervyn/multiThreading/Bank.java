package org.github.mervyn.multiThreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: Bank
  * @Description: A bank with a number of accounts
  * @author: mervyn 
  * @date 2016年1月5日 下午9:16:24
  *
  */
public class Bank {
	
	/**
	  * @Fields accounts : TODO（账户数组）
	  */
	private final double[] accounts;
	
	/**
	  * @Fields logger : TODO（日志对象）
	  */
	private static Logger logger = LoggerFactory.getLogger(TransferRunnable.class);
	
	/**
	
	  * 创建一个新的Bank对象. 
	  * <p>Title: 创建一个新的 Bank对象</p>
	  * <p>Description: 创建一个新的 Bank对象</p>
	  * @param n ：the number of accounts
	  * @param initailBalance : the initial balance of each account
	  */
	public Bank(int n,double initialBalance){
		accounts = new double[n];
		for(int i = 0; i < accounts.length; i++){
			accounts[i] = initialBalance;
		}
	}
	
	/**
	 * @throws InterruptedException 
	  * transfer(如果from账户现有的钱大于amount,则将from账户中amount数量的钱转移到to账户中，否则不转移。)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: transfer
	  * @Description: TODO
	  * @param @param from
	  * @param @param to
	  * @param @param amount  
	  * @return void
	  * @throws
	  */
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
		/*if(accounts[from] < amount){
			return;
		}else{
			accounts[from] -= amount;
			//为了让效果扩大，让线程睡眠1000毫秒
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.debug("从" + from + "账户转账" + amount + "元到" + to + "账户");
			accounts[to] += amount;
			logger.debug("Total Balance:" + this.getTotalBalance());
			
		}*/
		while(accounts[from] < amount){
			wait();
		}
		accounts[from] -= amount;
		//为了让效果扩大，让线程睡眠1000毫秒
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("从" + from + "账户转账" + amount + "元到" + to + "账户");
		accounts[to] += amount;
		logger.debug("Total Balance:" + this.getTotalBalance());
		notify();
	}
	
	/**
	  * getTotalBalance(Gets the sum of all account balances)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: getTotalBalance
	  * @Description: TODO
	  * @param @return  
	  * @return double
	  * @throws
	  */
	public synchronized double getTotalBalance(){
		double sum = 0;
		for(double a : accounts){
			sum += a;
		}
		return sum;
		
	}
	
	/**
	  * size(Gets the number of accounts in the bank)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: size
	  * @Description: TODO
	  * @param @return  
	  * @return int
	  * @throws
	  */
	public int size(){
		return accounts.length;
	}
}
