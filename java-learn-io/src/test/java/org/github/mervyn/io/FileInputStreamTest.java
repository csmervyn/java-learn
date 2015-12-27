package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: FileInputStreamTest
  * @Description: 测试FileInputStream
  * @author: mervyn 
  * @date 2015年12月26日 上午11:28:07
  *
  */
public class FileInputStreamTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	  * testFileInputStream1(测试FileInputStream（File file）构造函数，构造节点输入流)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testFileInputStream
	  * @Description: 测试FileInputStream（File file）构造函数，构造节点输入流
	  * @param @throws IOException    
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testFileInputStream1() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造一个FileInputStream
		InputStream in = new FileInputStream(f);
		byte[] b = new byte[(int) f.length()];
		//从输入流中读取数据，一次性读入所有字节
		int len = in.read(b);
		//关闭输入流
		in.close();
		logger.debug("读入了" + len + "个字节的数据");
		logger.debug("读入的数据是：" + new String(b));
	}
	
	

}
