package org.github.mervyn.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

/**
  * @ClassName: ZipOutputStreamTest
  * @Description: 测试ZipOutputStream
  * @author: mervyn 
  * @date 2015年12月27日 下午8:40:06
  *
  */
public class ZipOutputStreamTest {

	@Test
	public void testZipOutputStream() throws IOException  {
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.txt";
		File file = new File(pathname);
		
		String zipPathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.zip";
		File zipFile = new File(zipPathname);
		
		//构造FileOutputStream,第一个参数是File
		OutputStream zfout = new FileOutputStream(zipFile);
		ZipOutputStream zout = new ZipOutputStream(zfout);
		ZipEntry zipEntry = new ZipEntry(file.getName());
		zout.putNextEntry(zipEntry);
		zout.setComment("测试");
		
		FileInputStream fin = new FileInputStream(file);
		byte[] b = new byte[1000];
		fin.read(b);
		zout.write(b);
		
		fin.close();
		zout.close();
		
		
		zout.close();
		
		
	}

}
