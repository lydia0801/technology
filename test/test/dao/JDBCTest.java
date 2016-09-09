package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JDBCTest {
	
	@Test
	public void select(){
		System.out.println("asdfsdaf");
		
		int fileLevelId = 1;
		
		/**
		 * 第一步：导入JDBC驱动包，并且加载驱动类
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		/**
		 * 第二步：获取数据库连接对象
		 */
		String url = "jdbc:mysql://127.0.0.1:3306/media_1";
		String user = "root";
		String password = "icss";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		try {
			/**
			 * 第三步：获取预处理的SQL语句对象
			 */
			PreparedStatement pstmt = conn.prepareStatement("select * from file_level ");//where file_level_id>?
			
			/**
			 * 第四步：设置预处理的SQL语句对象的参数,set...(index,.)
			 */
			//pstmt.setInt(1, fileLevelId);
			
			/**
			 * 第五步：执行预处理的SQL语句对象，获取记录集对象
			 */
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){//遍历记录集
				System.out.println(rs.getInt("file_level_id") +"\t"+rs.getString("file_level_name"));//通过rs.get...方法，获取字段的值
				
			}
			
			/**
			 * 关闭记录集
			 */
			rs.close();
			
	
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			/**
			 * 关闭连接
			 */
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	@Test
	public void insert(){
		System.out.println("asdfsdaf");
		
		int fileLevelId = -1;
		String fileLevelName = "测试";
		
		/**
		 * 第一步：导入JDBC驱动包，并且加载驱动类
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		/**
		 * 第二步：获取数据库连接对象
		 */
		String url = "jdbc:mysql://127.0.0.1:3306/media_1?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "icss";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		try {
			/**
			 * 第三步：获取预处理的SQL语句对象
			 */
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO file_level(file_level_id,file_level_name) VALUES(?,?);");
			
			/**
			 * 第四步：设置预处理的SQL语句对象的参数,set...(index,.)
			 */
			pstmt.setInt(1, fileLevelId);
			pstmt.setString(2, fileLevelName);
			/**
			 * 第五步：执行预处理的SQL语句对象
			 */
			pstmt.executeUpdate();
			
	
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			/**
			 * 关闭连接
			 */
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
