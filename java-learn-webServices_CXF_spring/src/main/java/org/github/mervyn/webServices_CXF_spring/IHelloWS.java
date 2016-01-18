package org.github.mervyn.webServices_CXF_spring;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
  * @ClassName: IHelloWS
  * @Description: HelloWS的接口（SEI接口）
  * @author: mervyn 
  * @date 2016年1月14日 下午9:58:05
  *
  */

@WebService
public interface IHelloWS {
	@WebMethod
	public String sayHello(String name);
}
