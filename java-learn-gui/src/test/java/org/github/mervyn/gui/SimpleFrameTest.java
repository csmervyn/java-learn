package org.github.mervyn.gui;

import static org.junit.Assert.*;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.junit.Test;

public class SimpleFrameTest {

	@Test
	public void test() {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
