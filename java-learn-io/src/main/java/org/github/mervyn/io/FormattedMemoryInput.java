package org.github.mervyn.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
  * @ClassName: FormattedMemoryInput
  * @Description: 格式化的内存输入
  * @author: mervyn 
  * @date 2016年3月24日 上午10:38:59
  *
  */
public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException{
		String str = "I want to learn java. 循序渐进";
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(str.getBytes()));
		try {
			
			while (true) {
				System.out.print((char) in.readByte());
			} 
			
		} catch (EOFException e) {
			System.err.println("End of stream");
		}
		in.close();
	}
}
