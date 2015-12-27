package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.junit.Test;

/**
  * @ClassName: OutputStreamWriterTest
  * @Description: 测试OutputStreamWriter
  * @author: mervyn 
  * @date 2015年12月26日 下午3:55:00
  *
  */
public class OutputStreamWriterTest {

	@Test
	public void testOutputStreamWriter() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造OutputStream
		OutputStream out = new FileOutputStream(f);
		//将字节输出流转换成字符输出流
		Writer writer = new OutputStreamWriter(out);
		String str = "Do you love java ?";
		writer.write(str);
		writer.close();	
	}

}
