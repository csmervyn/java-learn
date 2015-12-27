package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

/**
  * @ClassName: OutputStreamTest
  * @Description: 测试OutputStream
  * @author: mervyn 
  * @date 2015年12月26日 上午11:28:40
  *
  */
public class OutputStreamTest {

	/**
	  * testOutputStream1(测试OutputStream（File file）构造函数，构造节点输出流，向文件以字节的方式写入（覆盖原来的数据）)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testOutputStream
	  * @Description: 测试OutputStream（File file）构造函数，构造节点输出流
	  * @param @throws IOException    
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testOutputStream1() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造FileOutputStream,第一个参数是File
		OutputStream out = new FileOutputStream(f);
		String str = "I love my family.";
		byte[] b = str.getBytes();
		out.write(b);
		out.close();
	}
	
	
	/**
	  * testOutputStream2(测试OutputStream（File file,Boolean boolean）构造函数，构造节点输出流，向文件以字节的方式写入（true是追加，false是覆盖）)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testOutputStream2
	  * @Description: 测试OutputStream（File file,Boolean boolean）构造函数，构造节点输出流，向文件以字节的方式写入（true是追加，false是覆盖）
	  * @param @throws IOException    
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testOutputStream2() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		//构造FileOutputStream。第一个参数是File。第二个参数是Boolean值，true表示追加，false表示覆盖。
		OutputStream out = new FileOutputStream(f,true);
		String str = "I also love java.";
		byte[] b = str.getBytes();
		out.write(b);
		out.close();
	}

}
