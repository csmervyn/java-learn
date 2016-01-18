package org.github.mervyn.webservices_cxf_springClient;

import static org.junit.Assert.*;

import org.github.mervyn.webservices_cxf_spring.IHelloWS;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CXFSpringClientTest {
	protected static Logger logger = LoggerFactory.getLogger(CXFSpringClientTest.class);
	@Test
	public void test() {
		// START SNIPPET: client
		ClassPathXmlApplicationContext context
		            = new ClassPathXmlApplicationContext(new String[] {"cxf-client.xml"});
		IHelloWS iHelloWs = (IHelloWS) context.getBean("helloWSClient");
		String result = iHelloWs.sayHello("mervyn");
		logger.debug("返回值是： " + result);
	}

}
