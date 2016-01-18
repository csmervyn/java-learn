package org.github.mervyn.webServices_CXF;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
  * @ClassName: HelloWS
  * @Description: web service endPoint interface(SEI), HelloWS接口
  * @author: mervyn 
  * @date 2016年1月14日 下午3:59:44
  *
  */

@WebService
public interface HelloWS {
	@WebMethod
	String sayHello(String name);
}
