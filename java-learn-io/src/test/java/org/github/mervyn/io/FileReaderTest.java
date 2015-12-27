package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: FileReaderTest
  * @Description: 测试FileReader
  * @author: mervyn 
  * @date 2015年12月26日 上午11:16:27
  *
  */
public class FileReaderTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testFileReader(测试FileReader(File file)构造方法，构造字符输入流)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testFileReader
	  * @Description: 测试FileReader(File file)构造方法，构造字符输入流
	  * @param @throws IOException    设定文件
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testFileReader() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造一个FileReader
		Reader reader = new FileReader(f);
		//假定该字符数组的大小够存储这些从FileReader中读取的字符
		char[] chars = new char[100];
		int count = reader.read(chars);
		reader.close();
		logger.debug("读入字符" + count + "个字符");
		logger.debug("内容为：" + new String(chars));
	}

}
