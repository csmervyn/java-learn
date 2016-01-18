package org.github.mervyn.webServicesClient;

import static org.junit.Assert.*;

import org.github.mervyn.webservices.HelloWSImpl;
import org.github.mervyn.webservices.HelloWSImplService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientTest {

	protected static Logger logger = LoggerFactory.getLogger(ClientTest.class);
	
	@Test
	public void test() {
		/*
		 * 生成的org.github.mervyn.webservices包下，HelloWSImpl是接口，HelloWSImplService是生成
		 * HelloWSImpl接口的实现
		 * */
		
		HelloWSImplService factory = new HelloWSImplService();
		//获得代理对象
		HelloWSImpl helloWSImpl = factory.getHelloWSImplPort();
		//通过代理对象调用远端的方法
		String result = helloWSImpl.sayHello("mervyn");
		logger.debug("调用web service后的返回值为：" + result);
	}

}
