package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

/**
  * @ClassName: BufferedOutputStreamTest
  * @Description: 测试BufferedOutputStream
  * @author: mervyn 
  * @date 2015年12月26日 下午4:49:41
  *
  */
public class BufferedOutputStreamTest {

	/**
	  * testBufferedOutputStream(测试OutputStream BufferedOutputStream(InputStream in)方法，带有输出缓冲区)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testBufferedOutputStream
	  * @Description: 测试OutputStream BufferedOutputStream(InputStream in)方法，带有输出缓冲区
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testBufferedOutputStream() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		OutputStream out = new FileOutputStream(f);
		OutputStream bos = new BufferedOutputStream(out);
		String str = "we love my family.";
		bos.write(str.getBytes());
		bos.close();
	}

}
