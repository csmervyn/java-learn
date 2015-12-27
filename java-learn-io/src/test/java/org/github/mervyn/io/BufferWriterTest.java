package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.Test;

/**
  * @ClassName: BufferWriterTest
  * @Description: 测试BufferWriter
  * @author: mervyn 
  * @date 2015年12月26日 下午5:25:50
  *
  */
public class BufferWriterTest {

	/**
	  * testBufferWriter(测试BufferWriter(Writer out)方法)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testBufferWriter
	  * @Description: 测试BufferWriter(Writer out)方法
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testBufferWriter() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		Writer fw = new FileWriter(f);
		
		Writer bw = new BufferedWriter(fw);
		String str ="12月26，我很高兴";
		bw.write(str);
		bw.close();
	}

}
