package org.github.mervyn.net;

import static org.junit.Assert.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InetAddressTest {
	protected static Logger logger = LoggerFactory.getLogger(InetAddressTest.class);
	
	/**
	  * testInetAddress(获取本地Host名和ip地址)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testInetAddress
	  * @Description: TODO
	  * @param   
	  * @return void
	  * @throws
	  */
	@Test
	public void testInetAddress() {
		try {
			//InetAddress是Java对IP地址的封装
			InetAddress localHostAddress = InetAddress.getLocalHost();
			logger.debug("本机的InetAdress对象:" + localHostAddress);
			logger.debug("本机主机名为：" + localHostAddress.getHostName());
			logger.debug("本机ip为：" + localHostAddress.getHostAddress());
		} catch (UnknownHostException e) {
			logger.debug("出现UnknownHostException");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNetInetAddress(){
		String host = "www.baidu.com";
		//InetAddress是Java对IP地址的封装
		InetAddress[] addresses = null;
		try {
			addresses = InetAddress.getAllByName(host);
		} catch (UnknownHostException e) {
			logger.debug("出现UnknownHostException");
			e.printStackTrace();
		}
		for(InetAddress temp : addresses){
			logger.debug("主机名为：" + temp.getHostName());
			logger.debug("ip为：" + temp.getHostAddress());
		}
		
	}

}
