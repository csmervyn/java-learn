package org.github.mervyn.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
  * @ClassName: BasicFileOutput
  * @Description: 基本文件输出
  * @author: mervyn 
  * @date 2016年3月24日 上午11:05:38
  *
  */
public class BasicFileOutput {
	public static void main(String[] args) throws IOException{
		String str = "I want to learn java. 循序渐进";
		String filename = "test.txt";
		Path path = Paths.get("src", "test","resources",filename);
		File file = new File(path.toAbsolutePath().toString());
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		out.println(str);
		out.close();
	}
}
