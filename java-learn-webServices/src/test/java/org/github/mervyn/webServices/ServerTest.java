package org.github.mervyn.webServices;

import static org.junit.Assert.*;

import javax.xml.ws.Endpoint;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ServerTest {
	protected static Logger logger = LoggerFactory.getLogger(ServerTest.class);
	public static void main(String[] args) {
		//端口号随意指定，但需确保其它应用程序没有占用该端口
		String address = "http://219.244.92.58:8989/webServices/HelloWS";
		//new SEI接口的实现类
		HelloWS implementor = new HelloWSImpl();
		//发布服务
		Endpoint.publish(address, implementor);
		logger.debug("HelloWS Web Services发布成功。");
	}
}
