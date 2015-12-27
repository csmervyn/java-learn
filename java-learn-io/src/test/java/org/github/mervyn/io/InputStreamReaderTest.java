package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: InputStreamReaderTest
  * @Description: 测试InputStreamReader，把字节流输入流转换字符输入流
  * @author: mervyn 
  * @date 2015年12月26日 下午3:35:16
  *
  */
public class InputStreamReaderTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testInputStreamReader(测试Reader InputStreamReader(InputStream in)方法，将字节输入流转换成字符输入流)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testInputStreamReader
	  * @Description: 测试Reader InputStreamReader(InputStream in)方法，将字节输入流转换成字符输入流
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testInputStreamReader() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造一个FileInputStream
		InputStream in = new FileInputStream(f);
		//将InputStream转换成Reader
		Reader reader = new InputStreamReader(in);
		//假定该字符数组的容量可以存储下从文件中读入的这些字符
		char[] chars = new char[100];
		int count = reader.read(chars);
		reader.close();
		logger.debug("从文件中读入了" + count + "个字符");
		logger.debug("内容为：" + new String(chars));
	}

}
