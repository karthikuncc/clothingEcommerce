package com.clothingcloset.databaseconnections;

import static com.clothingcloset.constants.ClothingClosetData.DB_URL;
import static com.clothingcloset.constants.ClothingClosetData.PASSWORD;
import static com.clothingcloset.constants.ClothingClosetData.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public Connection connectToDatabase() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		if(conn!=null){
			System.out.println("Connection is successfully established.");
		}else{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception raised while connecting to the database.");
			}
		}
		return conn;
	}
}
