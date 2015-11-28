package org.github.mervyn.java_learn.foundation.auto_incremental_statement;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutoIncrementalStatementTest {

	@Test
	public void testAutoIncrement() {
		AutoIncrementalStatement autoIncrement = new AutoIncrementalStatement();
		int i = 0;
		autoIncrement.autoIncrement(i);
		i = i++;
		//i++;
		/*
		 * 
		 * 
		 * 
		 * */
		
		System.out.println(i);
	}

}
