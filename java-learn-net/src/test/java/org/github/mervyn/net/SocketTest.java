package org.github.mervyn.net;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketTest {

	protected static Logger logger = LoggerFactory.getLogger(SocketTest.class);
	
	@Test
	public void testSocket() {
		String address = "time-A.timefreq.bldrdoc.gov";
		int port = 13;
		try {
			Socket socket = new Socket(address, port);
			InputStream in = socket.getInputStream();
			
			Scanner scanner = new Scanner(in);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				logger.debug(line);
			}
		} catch (UnknownHostException e) {
			logger.debug("发生UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			logger.debug("发生IOException");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSocketClient(){
		String address = "localhost";
		int port = 8189;
		try {
			Socket socket = new Socket(address, port);
			OutputStream out = socket.getOutputStream();
			PrintWriter pwriter = new PrintWriter(out, true);
			pwriter.println("my name is mervyn.");
			
			
			InputStream in = socket.getInputStream();
			
			Scanner scanner = new Scanner(in);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				logger.debug(line);
			}
		} catch (UnknownHostException e) {
			logger.debug("发生UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			logger.debug("发生IOException");
			e.printStackTrace();
		}
	}

}
