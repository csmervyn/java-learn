package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.junit.Test;

/**
  * @ClassName: PrintWriterTest
  * @Description: 测试PrintWriter
  * @author: mervyn 
  * @date 2015年12月27日 上午11:17:50
  *
  */
public class PrintWriterTest {

	/**
	  * testPrintWriter(测试PrintWriter)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testPrintWriter
	  * @Description: 测试PrintWriter
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testPrintWriter() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		
		Writer fwriter = new FileWriter(f);
		
		PrintWriter pw = new PrintWriter(fwriter);
		
		pw.println("I love my parent.");
		pw.close();
	}

}
