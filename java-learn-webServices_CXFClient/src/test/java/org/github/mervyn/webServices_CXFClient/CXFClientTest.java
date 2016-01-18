package org.github.mervyn.webServices_CXFClient;

import static org.junit.Assert.*;

import org.github.mervyn.webservices_cxf.HelloWS;
import org.github.mervyn.webservices_cxf.HelloWSImplService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: CXFClientTest
  * @Description: 测试CXF客户端
  * @author: mervyn 
  * @date 2016年1月14日 下午5:20:03
  *
  */
public class CXFClientTest {
	
	protected static Logger logger = LoggerFactory.getLogger(CXFClientTest.class);
	
	@Test
	public void testCXFClient() {
		//生成web service 容器
		HelloWSImplService factory = new HelloWSImplService();
		//通过容器获得代理对象
		HelloWS helloWS = factory.getHelloWSImplPort();
		//通过代理对象调用远端的对象的相应的方法
		String result = helloWS.sayHello("mervyn");
		logger.debug("web service 的返回值为： " + result );
	}

}
