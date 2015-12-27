package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
  * @ClassName: ObjectInputStreamTest
  * @Description: 测试ObjectInputStream
  * @author: mervyn 
  * @date 2015年12月26日 下午8:25:22
  *
  */
public class ObjectInputStreamTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testObjectInputStream(测试ObjectInputStream，从文件读取object对象)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testObjectInputStream
	  * @Description: TODO
	  * @param @throws IOException
	  * @param @throws ClassNotFoundException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testObjectInputStream() throws IOException, ClassNotFoundException {
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "serializableDemo.txt";
		File f = new File(pathname);
		InputStream fin = new FileInputStream(f);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object obj = oin.readObject();
		SerializableDemo sdemo = (SerializableDemo)obj;
		logger.debug(sdemo.toString());
	}

}
