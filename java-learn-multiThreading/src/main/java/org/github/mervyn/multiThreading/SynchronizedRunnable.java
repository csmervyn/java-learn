package org.github.mervyn.multiThreading;

/**
  * @ClassName: SynchronizedRunnable
  * @Description: 测试线程方法的同步，以小朋友分苹果为例
  * @author: mervyn 
  * @date 2016年1月5日 上午10:14:36
  *
  */
public class SynchronizedRunnable implements Runnable {

	/**
	  * @Fields appleCount : TODO（苹果的数量）
	  */
	private int appleCount = 5;
	
	/**
	  * consumeApple(取走苹果,加上synchronized关键字让该方法称为一个带有对象锁的同步方法)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: consumeApple
	  * @Description: 取走苹果，加上synchronized关键字让该方法称为一个带有对象锁的同步方法
	  * @param @return  
	  * @return boolean
	  * @throws
	  */
	public synchronized boolean consumeApple(){
		if(this.appleCount > 0){
			this.appleCount--;
			System.out.println(Thread.currentThread().getName() + "拿走了1个苹果，还剩下"
					+ this.appleCount + "个苹果");
			return true;
		}
		return false;
	}
	
	/*
	  * <p>Title: run</p>
	  * <p>Description: 线程体</p>
	  * @see java.lang.Runnable#run()
	  */
	
	public void run() {
		boolean flag = this.consumeApple();
		while(flag){
			flag = this.consumeApple();
		}
	}

}
