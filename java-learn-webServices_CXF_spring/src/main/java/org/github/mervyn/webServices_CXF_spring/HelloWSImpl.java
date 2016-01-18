package org.github.mervyn.webServices_CXF_spring;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
  * @ClassName: HelloWSImpl
  * @Description: HelloWSImpl接口
  * @author: mervyn 
  * @date 2016年1月14日 下午10:07:38
  *
  */
@WebService
/*@WebService(endpointInterface="org.github.mervyn.webServices_CXF_spring.IHelloWS", 
			serviceName="iHelloWS", 
			targetNamespace="http://localhost:8080/java-learn-webServices_CXF_spring")*/
//@Service("helloWSImpl")
public class HelloWSImpl implements IHelloWS {
	protected static Logger logger = LoggerFactory.getLogger(HelloWSImpl.class);
	public String sayHello(String name) {
		logger.debug("客户端传入值： " + name);
		String result = "Hello " + name;
		logger.debug("服务器端返回值： " + result);
		return result;
	}

}
