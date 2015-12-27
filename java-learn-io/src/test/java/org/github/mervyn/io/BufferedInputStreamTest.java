package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: BufferedInputStreamTest
  * @Description: 测试BufferedInputStream
  * @author: mervyn 
  * @date 2015年12月26日 下午4:11:44
  *
  */
public class BufferedInputStreamTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testBufferedInputStream(测试BufferedInputStream，带有缓存区的InputStream)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testBufferedInputStream
	  * @Description: BufferedInputStream内部有一个缓冲区，默认大小为8M，每次调用read方法的时候，
	  * 它首先尝试从缓冲区里读取数据，若读取失败（缓冲区无可读数据），则选择从物理数据源（譬如文件）读取新数据（这里会尝试尽可能读取多的字节）
	  * 放入到缓冲区中，最后再将缓冲区中的内容部分或全部返回给用户.由于从缓冲区里读取数据远比直接从物理数据源（譬如文件）读取速度快，
	  * 所以BufferedInputStream的效率很高！
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testBufferedInputStream() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造一个InputStream
		InputStream in = new FileInputStream(f);
		//构造一个带有缓冲器的InputStream
		InputStream bis = new BufferedInputStream(in);
		byte[] b = new byte[(int) f.length()];
		int len = bis.read(b);
		logger.debug("读入了" + len + "个字节");
		logger.debug("内容为：" + new String(b));
		
	}

}
