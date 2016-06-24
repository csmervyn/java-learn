package org.github.mervyn.io;

import java.io.IOException;
import java.io.StringReader;

/**
  * @ClassName: MemoryInput
  * @Description: 从内存输入
  * @author: mervyn 
  * @date 2016年3月24日 上午10:12:35
  *
  */
public class MemoryInput {
	public static void main(String[] args) throws IOException{
		String str = "I want to learn java.潜移默化";
		StringReader in = new StringReader(str);
		
		int c;
		while((c = in.read()) != -1){
			System.out.print((char)c);
		}
		in.close();
	}
}
