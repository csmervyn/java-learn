package org.github.mervyn.webServices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
  * @ClassName: HelloWS
  * @Description: 定义HelloWS的web services endPoint interface(SEI接口)
  * @author: mervyn 
  * @date 2016年1月13日 下午4:00:08
  *
  */
/**
 * 定义web services endPoint interface(SEI接口)
 * @WebService用于接口和实现类
 * @WebMethod用于方法
 * */
@WebService
public interface HelloWS {
	@WebMethod
	String sayHello(String name);
}
