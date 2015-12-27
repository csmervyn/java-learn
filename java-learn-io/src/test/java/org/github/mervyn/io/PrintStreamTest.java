package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
  * @ClassName: PrintStreamTest
  * @Description: 测试PrintStream
  * @author: mervyn 
  * @date 2015年12月27日 上午11:04:12
  *
  */
public class PrintStreamTest {

	/**
	  * testPrintStream(测试PrintStream(OutputStream out)构造方法)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testPrintStream
	  * @Description: 测试PrintStream(OutputStream out)构造方法
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testPrintStream() throws IOException {
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造FileOutputStream,第一个参数是File
		OutputStream fout = new FileOutputStream(f);
		PrintStream pout = new PrintStream(fout);
		pout.print("I love you my girl.");
		pout.close();
	}

}
