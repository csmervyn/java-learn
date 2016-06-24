package org.github.mervyn.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
  * @ClassName: BufferedInputFile
  * @Description: 从缓冲区中读出文件
  * @author: mervyn 
  * @date 2016年3月23日 下午3:14:36
  *
  */
public class BufferedInputFile {
	public static String read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null){
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException{
		String pathname = "src" + File.separator + "main" + File.separator + "java" + File.separator 
							+ "org" + File.separator + "github" + File.separator + "mervyn" + File.separator + "io" + File.separator +  "BufferedInputFile.java";

		System.out.println(read(pathname));
	}
}
