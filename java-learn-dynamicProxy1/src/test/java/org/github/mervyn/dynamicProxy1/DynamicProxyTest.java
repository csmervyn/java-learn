package org.github.mervyn.dynamicProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.github.mervyn.dynamicProxy1.ProxyHandler;
import org.github.mervyn.dynamicProxy1.RealSubject;
import org.github.mervyn.dynamicProxy1.Subject;
import org.junit.Test;

public class DynamicProxyTest {

	@Test
	public void test() {
		//被代理对象
		Subject subject = new RealSubject();
		//代理对象的代理逻辑
		InvocationHandler handler = new ProxyHandler(subject);
		
		//构造代理对象
		//该方法有3个参数：第一个，加载被代理对象的classloader；第二个，被代理对象要实现的接口；第三个，代理对象要实现的代理逻辑
		Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), 
														subject.getClass().getInterfaces(), 
														handler);
		proxy.doSomething();
		
	}

}
