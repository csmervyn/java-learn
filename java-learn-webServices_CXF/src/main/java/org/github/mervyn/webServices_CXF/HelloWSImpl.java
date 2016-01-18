package org.github.mervyn.webServices_CXF;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: HelloWSImpl
  * @Description: HelloWS接口的实现类
  * @author: mervyn 
  * @date 2016年1月14日 下午4:03:56
  *
  */
@WebService
public class HelloWSImpl implements HelloWS {
	protected static Logger logger = LoggerFactory.getLogger(HelloWSImpl.class);
	
	
	/*
	  * <p>Title: sayHello</p>
	  * <p>Description: 输入name,返回"Hello " + name的字符串</p>
	  * @param name
	  * @return
	  * @see org.github.mervyn.webServices_CXF.HelloWS#sayHello(java.lang.String)
	  */
	
	public String sayHello(String name) {
		String result = "Hello " + name;
		logger.debug("传入参数为： " + name + ";返回结果为： " + result);
		return result;
	}

}
