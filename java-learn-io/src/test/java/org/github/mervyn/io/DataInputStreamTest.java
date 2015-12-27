package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: DataInputStreamTest
  * @Description: 测试DataInputStream
  * @author: mervyn 
  * @date 2015年12月27日 上午10:41:00
  *
  */
public class DataInputStreamTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testDataInputStream(测试DataOutputStream的构造函数)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testDataInputStream
	  * @Description: 测试DataOutputStream的构造函数
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testDataInputStream() throws IOException {
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		
		InputStream fin = new FileInputStream(f);
		
		DataInputStream din = new DataInputStream(fin);
		int number = din.readInt();
		char[] chs = new char[50];
		char temp;
		int count = 0;
		while((temp = din.readChar()) != '.'){
			chs[count] = temp;
			count ++;
		}
		logger.debug("读入的int值为：" + number);
		logger.debug("读入的char数组为：" + new String(chs));
	}

}
