package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
  * @ClassName: RandomAccessFileTest
  * @Description: 测试RandomAccessFile
  * @author: mervyn 
  * @date 2015年12月27日 上午10:08:38
  *
  */
public class RandomAccessFileTest {

	@Test
	public void test() throws IOException{
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File f = new File(pathname);
		
		RandomAccessFile rcf = new RandomAccessFile(f, "rw");
		rcf.writeBytes("asdsad");
		rcf.writeInt(12);
		rcf.writeBoolean(true);
		rcf.writeChar('A');
		rcf.writeFloat(1.21f);
		rcf.writeDouble(12.123);
		rcf.close();
	}

}
