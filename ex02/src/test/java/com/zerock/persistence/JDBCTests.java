package com.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection conn = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","book_ex","1234")){
		log.info("conn2 : " + conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
