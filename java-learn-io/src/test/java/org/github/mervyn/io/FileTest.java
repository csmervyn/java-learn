package org.github.mervyn.io;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
  * @ClassName: FileTest
  * @Description: 测试文件的新建
  * @author: mervyn 
  * @date 2015年12月22日 下午10:17:04
  *
  */
public class FileTest {
	
	/**
	  * testFile
	  * TODO(测试创建File的对象，该对象可以表示一个具体的文件路径（文件或文件夹）)
	  *
	  * @Title: testFile
	  * @Description: 测试创建创建File的对象，该对象可以表示一个具体的文件路径（文件或文件夹）
	  * @param     无
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testFile(){
		String pathName = "src/test/resources/test.txt";
		//String pathName = "D:" + File.separator + "test.txt";	
		
		//File类对象可以表示一个具体的文件路径（文件或文件夹），在实际代表时，可以使用绝对路径也可以使用相对路径。
		File file = new File(pathName);
		
		if(file.exists()){
			System.out.println("该文件路径（文件或文件夹）存在.");
		}else{
			System.out.println("该文件路径（文件或文件夹）不存在.");
		}
	}
	
	/**
	  * testCreateNewFile
	  * TODO(根据指定的文件路径，创建一个空的文件。)
	  * TODO(该方法的作用是创建指定的文件。该方法只能用于创建文件，不能用于创建文件夹，且文件路径中包含的文件夹必须存在。)
	  * TODO(当所指定的文件不存在并且创建了一个空的文件时，返回true。当所指定的文件存在，返回false.)
	  *
	  * @Title: testCreateNewFile
	  * @Description: 测试File类中的createNewFile()
	  * @param     无
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testCreateNewFile(){
		String pathName = "src/test/resources/test.txt";
		File file = new File(pathName);
		try {
			//根据指定的文件路径，创建一个空的文件。当所指定的文件不存在并且创建了一个空的文件时，返回true。当所指定的文件存在，返回false.
			//该方法的作用是创建指定的文件。该方法只能用于创建文件，不能用于创建文件夹，且文件路径中包含的文件夹必须存在。
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	  * testMkdir
	  * TODO(该方法的作用是创建当前文件文件夹，而不创建该路径中的其它文件夹。假设d盘下只有一个test文件夹，则创建d:\test\abc文件夹则成功，
	  * 	如果创建d:\a\b文件夹则创建失败，因为该路径中d:\a文件夹不存在。如果创建成功则返回true，否则返回false。)
	  *
	  * @Title: testMkdir
	  * @Description: 创建一个目录
	  * @param     无
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testMkdir(){
		String pathName = "src/test/resources/test/";
		File file = new File(pathName);
		//文件夹
		Boolean flag = file.mkdir();
		if(flag){
			System.out.println("目录创建成功");
		}else{
			System.out.println("目录创建失败");
		}
	}
	
	/**
	  * testDelete
	  * TODO(该方法的作用是删除当前文件或文件夹。如果删除的是文件夹，则该文件夹必须为空。)
	  * TODO(如果需要删除一个非空的文件夹，则需要首先删除该文件夹内部的每个文件和文件夹，然后在可以删除，)
	  * TODO(这个需要书写一定的逻辑代码实现。)
	  *
	  * @Title: testDelete
	  * @Description: 测试File类的delete方法
	  * @param     设定文件
	  * @return void    返回类型
	  * @throws
	  */
	
	
	/**
	  * testDelete
	  * TODO(该方法的作用是删除当前文件或文件夹。如果删除的是文件夹，则该文件夹必须为空。)
	  * TODO(如果需要删除一个非空的文件夹，则需要首先删除该文件夹内部的每个文件和文件夹，然后在可以删除，)
	  * TODO(这个需要书写一定的逻辑代码实现。)
	  *
	  * @Title: testDelete
	  * @Description: 测试删除文件或路径
	  * @param     设定文件
	  * @return void    返回类型
	  * @throws
	  */

	@Test
	public void testDelete(){
		String pathName = "src/test/resources/test.txt";
		File file = new File(pathName);
		if(file.exists()){
			//该方法的作用是删除当前文件或文件夹。如果删除的是文件夹，则该文件夹必须为空。
			//如果需要删除一个非空的文件夹，则需要首先删除该文件夹内部的每个文件和文件夹，然后在可以删除，
			//这个需要书写一定的逻辑代码实现。
			Boolean flag = file.delete();
			if(flag){
				System.out.println("文件删除成功.");
			}else{
				System.out.println("文件删除失败.");
			}
		}else{
			System.out.println("文件不存在.");
		}
	}
	
	/**
	  * testRenameTo
	  * TODO(该方法的作用是修改文件名。在修改文件名时不能改变文件路径，如果该路径下已有该文件，则会修改失败。)
	  *
	  * @Title: testRenameTo
	  * @Description: 给文件换名
	  * @param     设定文件
	  * @return void    返回类型
	  * @throws
	  */
	@Test
	public void testRenameTo(){
		String pathName = "src/test/resources/test.txt";
		File file = new File(pathName);
		String destPathName = "src/test/resources/test1.txt";
		File destFile = new File(destPathName);
		Boolean flag = file.renameTo(destFile);
		if(flag){
			System.out.println("文件换名成功.");
		}else{
			System.out.println("文件换名失败.");
		}
	}

}
