package org.github.mervyn.dynamicProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
  * @ClassName: ProxyHandler
  * @Description: 将要插入到代理对象中的代理逻辑，代理逻辑封装在InvocationHandler接口的
  * 			 Object invoke(Object proxy, Method method, Object[] args)中。
  * @author: mervyn 
  * @date 2016年6月28日 下午9:26:15
  *
  */
public class ProxyHandler implements InvocationHandler {
	/**
	  * @Fields target : 被代理的对象
	  */
	private Object target;
	
	public ProxyHandler(Object target) {
		super();
		this.target = target;
	}
	
	/*
	  * <p>Title: invoke</p>
	  * <p>Description: 代理逻辑</p>
	  * @param proxy 代理类对象
	  * @param method 需要在代理逻辑中调用的被代理对象的方法
	  * @param args 被代理对象的方法需要的参数数组
	  * @return
	  * @throws Throwable
	  * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	  */
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object = null;
		// 添加被调用之前的逻辑
		System.out.println("添加被调用之前的逻辑");
		
		// 调用被代理对象的逻辑
		object = method.invoke(target, args);
		
		// 添加调用之后的逻辑
		System.out.println("添加调用之后的逻辑");
		return object;
	}

}
