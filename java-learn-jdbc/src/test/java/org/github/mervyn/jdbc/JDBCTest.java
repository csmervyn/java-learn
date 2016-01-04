package org.github.mervyn.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: JDBCTest
  * @Description: 测试jdbc的7个步骤
  * @author: mervyn 
  * @date 2015年12月29日 下午4:31:15
  *
  */
public class JDBCTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	  * testSelect(测试select)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testSelect
	  * @Description: 测试select
	  * @param @throws SQLException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testSelect(){
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try{
			//1、加载JDBC的数据库驱动
			//加载JDBC的数据库驱动，成功加载后，会将Driver类的实例注册到DriverManager类中。
			Class.forName("com.mysql.jdbc.Driver") ;
				
			//2、提供JDBC连接的URL
			//连接URL定义了连接数据库时的协议、子协议、数据源标识
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String username ="root";
			String password = "1234";
			
			//3、创建数据库的连接
			conn = DriverManager.getConnection(url, username, password);
			
			//4、创建一个Statement  
			/*要执行SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3  
		     	种类型：   
		      1、执行静态SQL语句。通常通过Statement实例实现。   
		      2、执行动态SQL语句。通常通过PreparedStatement实例实现。   
		      3、执行数据库存储过程。通常通过CallableStatement实例实现。 */
			statement = conn.createStatement();
		
			//5、执行SQL语句   
			/*
			 *  Statement接口提供了三种执行SQL语句的方法：executeQuery 、executeUpdate   
			   和execute   
			    1、ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句   
			        ，返回一个结果集（ResultSet）对象。   
			     2、int executeUpdate(String sqlString)：用于执行INSERT、UPDATE或   
			        DELETE语句以及SQL DDL语句，如：CREATE TABLE和DROP TABLE等   
			     3、execute(sqlString):用于执行返回多个结果集、多个更新计数或二者组合的   
			        语句。
			 * */
			String sql = "select * from user";
			rs = statement.executeQuery(sql);
			
			// 6、处理结果
			/*
			 * 两种情况：   
		     1、执行更新返回的是本次操作影响到的记录数。   
		     2、执行查询返回的结果是一个ResultSet对象。   
		    • ResultSet包含符合SQL语句中条件的所有行，并且它通过一套get方法提供了对这些   
		      行中数据的访问。   
		    • 使用结果集（ResultSet）对象的访问方法获取数据：   
		     while(rs.next()){   
		         String name = rs.getString("name") ;   
		    String pass = rs.getString(1) ; // 此方法比较高效   
		     }   
		    （列是从左到右编号的，并且从列1开始） 
			 * */
			while(rs.next()){
				int tempId = rs.getInt(1);
				String tempUsername = rs.getString(2);
				String tempPassword = rs.getString(3);
				User userTemp = new User(tempId, tempUsername, tempPassword);
				logger.debug(userTemp.toString());
			}
		}catch(ClassNotFoundException e){
			logger.debug("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}catch(SQLException e){
			logger.debug("可能出现以下问题：1、数据库连接失败；2、创建Statement出错了；3、执行sql出现错误");
			e.printStackTrace();
		}finally{
			//7、关闭JDBC对象    
		   /*  操作完成以后要把所有使用的JDBC对象全都关闭，以释放JDBC资源，关闭顺序和声   
		     明顺序相反：   
		     1、关闭记录集   
		     2、关闭声明   
		     3、关闭连接对象 */
			try{
				if(rs != null){
					rs.close();
				}
				if(statement != null){
					statement.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(SQLException e){
				logger.debug("可能出现以下问题：1、ResultSet关闭出现异常；2、关闭Statement出现错误；3、关闭Connection出现错误");;
			}
		}
	}
	
	/**
	  * testInsert(测试insert)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testInsert
	  * @Description: 测试insert
	  * @param @throws SQLException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testInsert(){
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try{
			//1、加载JDBC的数据库驱动
			//加载JDBC的数据库驱动，成功加载后，会将Driver类的实例注册到DriverManager类中。
			Class.forName("com.mysql.jdbc.Driver") ;
			
			//2、提供JDBC连接的URL
			//连接URL定义了连接数据库时的协议、子协议、数据源标识
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String username ="root";
			String password = "1234";
			
			//3、创建数据库的连接
			conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into user (id,username,password) values(?,?,?)";
			User user = new User(3,"max","333123");
			
			//4、创建一个Statement 
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			
			//5、执行SQL语句
			int rows = preparedStatement.executeUpdate();
			
			//6、处理结果
			if(rows > 0){
				logger.debug("成功插入" + user.toString());
			}else{
				logger.debug("插入失败");
			}
		}catch(ClassNotFoundException e){
			logger.debug("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}catch(SQLException e){
			logger.debug("可能出现以下错误：1、数据库连接失败；2、创建Statement失败；3、执行sql出现错误。");
			e.printStackTrace();
		}finally{
			//7、关闭连接
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(conn != null){
					conn.close();
				}	
			} catch (SQLException e) {
				logger.debug("可能出现以下错误：1、关闭PreparedStatement失败；2、关闭Connection失败。");
				e.printStackTrace();
			}
		}	
	}

	/**
	  * testUpdate(测试update)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testUpdate
	  * @Description: TODO
	  * @param @throws SQLException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testUpdate(){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try{
			//1、加载JDBC的数据库驱动
			//加载JDBC的数据库驱动，成功加载后，会将Driver类的实例注册到DriverManager类中。
			Class.forName("com.mysql.jdbc.Driver") ;
			
			//2、提供JDBC连接的URL
			//连接URL定义了连接数据库时的协议、子协议、数据源标识
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String username ="root";
			String password = "1234";
			//3、创建数据库的连接
			conn = DriverManager.getConnection(url, username, password);
			User user = new User(2,"Tom","898090");
			String sql = "update user set username='" + user.getUsername()
						+ "' where id=" + user.getId();
			//4、创建Statement
			preparedStatement = conn.prepareStatement(sql);
			
			//5、执行SQL语句
			int rows = preparedStatement.executeUpdate();
			
			//6、处理结果
			if(rows > 0){
				logger.debug("修改id为" + user.getId() + "的user成功");
			}else{
				logger.debug("修改失败");
			}
		}catch(ClassNotFoundException e){
			logger.debug("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}catch(SQLException e){
			logger.debug("可能出现以下的错误：1、数据库连接失败；2、创建PreparedStatement出现错误；3、执行sql出现错误。");
			e.printStackTrace();
		}finally{
			//7、关闭连接
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				logger.debug("可能出现以下错误：1、关闭PreparedStatement失败；2、关闭Connection失败。");
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	  * testDelete(测试SQL的批量操作)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testDelete
	  * @Description: 测试SQL的批量操作
	  * @param @throws SQLException  
	  * @return void
	  * @throws
	  */
	@Test
	public void testDelete(){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try{
			//1、加载JDBC的数据库驱动
			//加载JDBC的数据库驱动，成功加载后，会将Driver类的实例注册到DriverManager类中。
			Class.forName("com.mysql.jdbc.Driver") ;

			//2、提供JDBC连接的URL
			//连接URL定义了连接数据库时的协议、子协议、数据源标识
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String username ="root";
			String password = "1234";
			//3、创建数据库的连接
			conn = DriverManager.getConnection(url, username, password);
			
			int id = 3;
			String sql = "delete from user where id = " + id +"";
			

			//4、创建一个Statement 
			preparedStatement = conn.prepareStatement(sql);

			//5、执行SQL语句
			int rows = preparedStatement.executeUpdate();
			
			//6、处理结果
			if(rows > 0){
				logger.debug("删除id为" + id + "的user成功");
			}else{
				logger.debug("删除失败");
			}
		}catch(ClassNotFoundException e){
			logger.debug("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}catch(SQLException e){
			logger.debug("可能出现以下的错误：1、数据库连接失败；2、创建Statement失败；3、执行sql出现错误。");
			e.printStackTrace();
		}
		//7、关闭连接
		try {
			if(preparedStatement != null){
				preparedStatement.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			logger.debug("可能出现如下的错误：1、Statement关闭失败；2、Connection关闭失败");
			e.printStackTrace();
		}
	}
	
	/**
	  * testBatch(这里用一句话描述这个方法的作用)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: testBatch
	  * @Description: TODO
	  * @param   
	  * @return void
	  * @throws
	  */
	@Test
	public void testBatch(){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try{
			//1、加载JDBC的数据库驱动
			//加载JDBC的数据库驱动，成功加载后，会将Driver类的实例注册到DriverManager类中。
			Class.forName("com.mysql.jdbc.Driver") ;
			
			//2、提供JDBC连接的URL
			//连接URL定义了连接数据库时的协议、子协议、数据源标识
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String username ="root";
			String password = "1234";
			
			//3、创建数据库的连接
			conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into user (id,username,password) values(?,?,?)";
			User user1 = new User(3,"max","333123");
			User user2 = new User(4,"Tom","898898");
			User user3 = new User(5,"Ketty","888849");
			
			//4、创建一个Statement 
			preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setInt(1, user1.getId());
			preparedStatement.setString(2, user1.getUsername());
			preparedStatement.setString(3, user1.getPassword());
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, user2.getId());
			preparedStatement.setString(2, user2.getUsername());
			preparedStatement.setString(3, user2.getPassword());
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, user3.getId());
			preparedStatement.setString(2, user3.getUsername());
			preparedStatement.setString(3, user3.getPassword());
			preparedStatement.addBatch();
			
			
			//5、执行SQL语句
			
			//= preparedStatement.executeBatch();
			int [] rows = preparedStatement.executeBatch();
			//6、处理结果
			if(rows.length == 3){
				logger.debug("成功批量插入:" + user1.toString() + "---" + user2.toString() + "----" + user3.toString());
			}else{
				logger.debug("批量插入失败");
			}
		}catch(ClassNotFoundException e){
			logger.debug("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}catch(SQLException e){
			logger.debug("可能出现以下错误：1、数据库连接失败；2、创建Statement失败；3、执行sql出现错误。");
			e.printStackTrace();
		}finally{
			//7、关闭连接
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(conn != null){
					conn.close();
				}	
			} catch (SQLException e) {
				logger.debug("可能出现以下错误：1、关闭PreparedStatement失败；2、关闭Connection失败。");
				e.printStackTrace();
			}
		}
	}
	
	
	@Test
	public void testTransaction(){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try{
			//1、加载JDBC的数据库驱动
			//加载JDBC的数据库驱动，成功加载后，会将Driver类的实例注册到DriverManager类中。
			Class.forName("com.mysql.jdbc.Driver") ;
			
			//2、提供JDBC连接的URL
			//连接URL定义了连接数据库时的协议、子协议、数据源标识
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String username ="root";
			String password = "1234";
			
			//3、创建数据库的连接
			conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into user (id,username,password) values(?,?,?)";
			User user1 = new User(3,"max","333123");
			User user2 = new User(4,"Tom","898898");
			User user3 = new User(5,"Ketty","888849");
			
			//默认情况下Statement会自动提交事物，因此在该处设置为不自动提交事物。
			conn.setAutoCommit(false);
			
			
			//4、创建一个Statement 
			preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setInt(1, user1.getId());
			preparedStatement.setString(2, user1.getUsername());
			preparedStatement.setString(3, user1.getPassword());
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, user2.getId());
			preparedStatement.setString(2, user2.getUsername());
			preparedStatement.setString(3, user2.getPassword());
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, user3.getId());
			preparedStatement.setString(2, user3.getUsername());
			preparedStatement.setString(3, user3.getPassword());
			preparedStatement.addBatch();
			
			//提交事物
			conn.commit();
			//恢复自动提交事物
			conn.setAutoCommit(true);
			
			//5、执行SQL语句
			
			//= preparedStatement.executeBatch();
			int [] rows = preparedStatement.executeBatch();
			//6、处理结果
			if(rows.length == 3){
				logger.debug("成功批量插入:" + user1.toString() + "---" + user2.toString() + "----" + user3.toString());
			}else{
				logger.debug("批量插入失败");
			}
		}catch(ClassNotFoundException e){
			logger.debug("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}catch(SQLException e){
			logger.debug("可能出现以下错误：1、数据库连接失败；2、创建Statement失败；3、执行sql出现错误。");
			e.printStackTrace();
			if(conn != null){
				try {
					//回滚事物
					conn.rollback();
					//恢复自动提交事物
					conn.setAutoCommit(true);
				} catch (SQLException e1) {
					logger.debug("事物回滚出现错误。");
					e1.printStackTrace();
				}
			}
		}finally{
			//7、关闭连接
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(conn != null){
					conn.close();
				}	
			} catch (SQLException e) {
				logger.debug("可能出现以下错误：1、关闭PreparedStatement失败；2、关闭Connection失败。");
				e.printStackTrace();
			}
		}
	}
}
