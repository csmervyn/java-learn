package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: BufferedReaderTest
  * @Description: 测试BufferedReader
  * @author: mervyn 
  * @date 2015年12月26日 下午5:12:05
  *
  */
public class BufferedReaderTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testBufferedReader(测试BufferedReader(Reader in)方法,带有缓冲区)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testBufferedReader
	  * @Description: 测试BufferedReader(Reader in)方法,带有缓冲区
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testBufferedReader() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造一个FileReader
		Reader fr = new FileReader(f);
		//构造一个br
		Reader br = new BufferedReader(fr);
		//假定该字符数组的容量能够存储下从文件中读入的这些字符
		char[] chars = new char[100];
		int count = br.read(chars);
		br.close();
		logger.debug("读入" + count + "个字符");
		logger.debug("内容为：" + new String(chars));
	}

}
