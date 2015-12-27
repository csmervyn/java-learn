package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.Test;

/**
  * @ClassName: FileWriterTest
  * @Description: 测试FileWriter
  * @author: mervyn 
  * @date 2015年12月26日 上午11:26:18
  *
  */
public class FileWriterTest {

	/**
	  * testFileWriter(测试FileWriter(File file)构造方法，构造字符输出流)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testFileWriter
	  * @Description: 测试FileWriter(File file)构造方法，构造字符输出流
	  * @param @throws IOException    
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testFileWriter() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造一个FileWirter
		Writer writer = new FileWriter(f);
		
		String str ="how to learn the IO of java ?";
		
		//已字符流的方式向文件中写入字符串
		writer.write(str);
		writer.close();
	}

}
