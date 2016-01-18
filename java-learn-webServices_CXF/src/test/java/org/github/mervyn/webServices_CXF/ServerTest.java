package org.github.mervyn.webServices_CXF;

import static org.junit.Assert.*;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: ServerTest
  * @Description: 测试web services 的发布（用cxf方式）
  * @author: mervyn 
  * @date 2016年1月14日 下午4:12:07
  *
  */
public class ServerTest {
	protected static Logger logger = LoggerFactory.getLogger(ServerTest.class);
	
	/**
	  * main(测试服务的发布)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: main
	  * @Description: 测试服务的发布
	  * @param @param args  
	  * @return void
	  * @throws
	  */
	public static void main(String[] args) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setAddress("http://219.244.92.58:8989/webServices_CXF/HelloWS");
		factory.setServiceClass(HelloWS.class);
		factory.setServiceBean(new HelloWSImpl());
		factory.create();
		
		logger.debug("HelloWS web service 发布成功");
	}
}
