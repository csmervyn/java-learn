package org.github.mervyn.net;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: ServerSocketTest
  * @Description: 测试ServerSocket类建立套接字
  * @author: mervyn 
  * @date 2016年1月6日 上午10:57:22
  *
  */
public class ServerSocketTest {
	protected static Logger logger = LoggerFactory.getLogger(ServerSocketTest.class);
	
	/**
	  * testServerSocket(测试Socket服务端)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testServerSocket
	  * @Description: 测试Socket服务端（以try-catch-finally的形式）
	  * @param   
	  * @return void
	  * @throws
	  */
	@Test
	public void testServerSocket() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		Scanner scanner = null;
		PrintWriter printWriter = null;

		try {
			//1、用于建立一个负责监听端口8189的服务器
			serverSocket = new ServerSocket(8189);
			//2、等待客户端连接
			socket = serverSocket.accept();
			//3、客户端的输入流
			in = socket.getInputStream();
		    scanner = new Scanner(in);
			//4、向客户端输出的输出流
			out = socket.getOutputStream();
		    printWriter = new PrintWriter(out, true);
			//结束标志
			boolean done = false;
			
			while(!done && scanner.hasNext()){
				String line = scanner.nextLine();
				printWriter.println("Echo:" + line);
				printWriter.println("Hello! Enter BYE to exit!");
				if(line.trim().equals("BYE")){
					done = true;
				}
			}
			
		} catch (IOException e) {
			logger.debug("可能出现以下的错误：");
			logger.debug("serverSocket建立出现IOException");
			logger.debug("socket接受客户端请求出现IOException");
			logger.debug("从客户端读取信息出现IOException");
			logger.debug("向客户端输出信息出现IOException");
			e.printStackTrace();
		}finally{
			printWriter.close();
			try {
				out.close();
			} catch (IOException e1) {
				logger.debug("OutputStream流关闭出现异常");
				e1.printStackTrace();
			}
			scanner.close();
			try {
				in.close();
			} catch (IOException e1) {
				logger.debug("InputStream关闭出现异常");
				e1.printStackTrace();
			}
			
			try {
				socket.close();
			} catch (IOException e) {
				logger.debug("socket关闭异常");
				e.printStackTrace();
			}
			try {
				serverSocket.close();
			} catch (IOException e) {
				logger.debug("serverSocket关闭异常");
				e.printStackTrace();
			}
		}
	}
	
	/**
	  * testServerSocket1(测试Socket服务端)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testServerSocket1
	  * @Description: 测试Socket服务端（以try-with-resouces的形式）
	  * @param   
	  * @return void
	  * @throws
	  */
	@Test
	public void testServerSocket1(){
		//1、用于建立一个负责监听端口8189的服务器
		try(ServerSocket serverSocket = new ServerSocket(8189)){
			//2、等待客户端连接
			try(Socket socket = serverSocket.accept()){
				try(InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream();
					Scanner scanner = new Scanner(in);
					PrintWriter printWriter = new PrintWriter(out, true);){
					
					//结束标志
					boolean done = false;
					while(!done && scanner.hasNext()){
						//3、客户端的输入流
						String line = scanner.nextLine();
						//4、向客户端输出的输出流
						printWriter.println("Echo:" + line);
						printWriter.println("Hello! Enter BYE to exit!");
						if(line.trim().equals("BYE")){
							done = true;
						}
					}
				}
			}catch (IOException e1) {
				logger.debug("socket接受客户端请求出现IOException");
				e1.printStackTrace();
			}
		} catch (IOException e) {
			logger.debug("serverSocket建立出现IOException");
			e.printStackTrace();
		}
	}

}
