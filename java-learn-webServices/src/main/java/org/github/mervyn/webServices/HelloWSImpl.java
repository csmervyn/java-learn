package org.github.mervyn.webServices;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: HelloWSImpl
  * @Description: HelloWS的实现类（即web services endPoint interface接口的实现类）
  * @author: mervyn 
  * @date 2016年1月13日 下午4:10:57
  *
  */
/*
 * @WebService中：
 * 	name：该web service的name，对应WSDL 1.1中wsdl:portType。
 * 	portName：该web service的port name，对应WSDL 1.1中wsdl:port（虽然在WSDL2.0中使用<endport>元素代替了<port>元素，
 * 		但不允许该值用于<endport>元素）。	
 * 	serviceName：该web service的service name，对应WSDL 1.1中wsdl:service（虽然在WSDL2.0中使用<endport>元素代替了<port>元素，
 * 		但不允许该值用于<endport>元素）。
 * 	endpointInterface：service endpoint interface 全名。
 * */
@WebService(
		name = "HelloWSService",
		portName = "HelloWSServicePort",
		serviceName = "HelloWSService",
		endpointInterface = "org.github.mervyn.webServices.HelloWS"
		)
public class HelloWSImpl implements HelloWS {
	protected static Logger logger = LoggerFactory.getLogger(HelloWSImpl.class);
	public String sayHello(String name) {
		String result = "Hello " + name;
		logger.debug("调用web services 的 sayHello()，传入参数：" + name + ";返回值是：" + result);
		return result;
	}

}
