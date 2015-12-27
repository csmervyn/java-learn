package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

/**
  * @ClassName: DataOutputStreamTest
  * @Description: 测试DataOutputStream，将java基本数据类型写入数据输出流中。
  * @author: mervyn 
  * @date 2015年12月27日 上午10:17:32
  *
  */
public class DataOutputStreamTest {

	/**
	  * testDataOutputStream(测试DataOutputStream(OutputStream out)的构造方法)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testDataOutputStream
	  * @Description: 测试DataOutputStream(OutputStream out)的构造方法
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testDataOutputStream() throws IOException {
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		OutputStream fout = new FileOutputStream(f);
		
		DataOutputStream dout = new DataOutputStream(fout);
		int number = 234;
		dout.writeInt(number);
		String str = "I love my family.";
		dout.writeChars(str);
		dout.close();
	}

}
