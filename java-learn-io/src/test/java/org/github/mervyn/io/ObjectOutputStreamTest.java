package org.github.mervyn.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;


/**
  * @ClassName: ObjectOutputStreamTest
  * @Description: 测试ObjectOutputStream
  * @author: mervyn 
  * @date 2015年12月26日 下午8:08:59
  *
  */
public class ObjectOutputStreamTest {
	
	/**
	  * testObjectOutputStream(测试ObjectOutputStream将一个（可序列化的）object写到文件中)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testObjectOutputStream
	  * @Description: 测试ObjectOutputStream将一个（可序列化的）object写到文件中
	  * @param @throws IOException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testObjectOutputStream() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "serializableDemo.txt";
		File f = new File(pathname);
		OutputStream fout = new FileOutputStream(f);
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		
		SerializableDemo sdemo = new SerializableDemo();
		sdemo.setName("mervyn");
		sdemo.setAge(25);
		
		oout.writeObject(sdemo);
		oout.close();	
	}
}
