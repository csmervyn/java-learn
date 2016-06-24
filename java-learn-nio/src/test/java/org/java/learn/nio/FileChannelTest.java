package org.java.learn.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: FileChannelTest
  * @Description: 测试FileChannel的相关方法
  * @author: mervyn 
  * @date 2016年3月24日 下午10:05:49
  *
  */
public class FileChannelTest {
	//日志对象logger
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	  * testWirte(测试通过Channel把Buffer中的内容写到文件中)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testWirte
	  * @Description: 测试通过Channel把Buffer中的内容写到文件中
	  * @param   
	  * @return void
	  * @throws
	  */
	@Test
	public void testWirte() {
		String str = "I want to learn java nio. 希望通过我的努力可以学会。";
		Path path = Paths.get("src", "test","resources","test.txt");
		try {
			FileOutputStream out = new FileOutputStream(path.toAbsolutePath().toString());
			//从流中获取Channel
			FileChannel channel = out.getChannel();
			//创建Buffer
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			//将数据放入Buffer中
			buffer.put(str.getBytes());
			//flip()使缓冲区为一系列新的通道写入或相对获取操作做好准备
			buffer.flip();
			//向Channel中写Buffer
			try {
				channel.write(buffer);
			} catch (IOException e) {
				logger.debug("向channel中写入出现异常");
				e.printStackTrace();
			}finally{
				try {
					channel.close();
					out.close();
				} catch (IOException e) {
					logger.debug("Channel或FileOutputStream关闭出现异常");
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			logger.debug("出现FileNotFoundException");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRead(){
		Path path = Paths.get("src", "test","resources","test.txt");
		try {
			ByteBuffer buf = ByteBuffer.allocate(1024);
			FileInputStream in = new FileInputStream(path.toAbsolutePath().toString());
			FileChannel channel = in.getChannel();
			try {
				int bytesRead = channel.read(buf);
				while(bytesRead != -1){
					System.out.println("Read: " + bytesRead);
					buf.flip();
					while(buf.hasRemaining()){
						System.out.print((char)buf.get());
					}
					buf.clear();
					bytesRead = channel.read(buf);
				}
				
			} catch (IOException e) {
				logger.debug("从Channel中读取数据到Buffer中失败");
				e.printStackTrace();
			}finally{
				try {
					channel.close();
					in.close();
				} catch (IOException e) {
					logger.debug("FileChannel或FileInputStream关闭出错");
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			logger.debug("未找到" + path.toAbsolutePath().toString() + "文件");
			e.printStackTrace();
		}
	}
}
