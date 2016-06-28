package org.github.mervyn.dynamicProxy1;

/**
  * @ClassName: RealSubject
  * @Description: 被代理的对象
  * @author: mervyn 
  * @date 2016年6月28日 下午9:21:27
  *
  */
public class RealSubject implements Subject {

	/*
	  * <p>Title: doSomething</p>
	  * <p>Description: 实现接口中定义的业务方法</p>
	  * @see org.github.mervyn.DynamicProxy.Subject#doSomething()
	  */
	public void doSomething() {
		System.out.println(this.getClass().getName() +"类的对象的 doSomething()方法正在执行...");
	}

}
