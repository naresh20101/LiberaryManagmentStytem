package com.DbManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection conn= null;
	public static Connection getConnection()
	{  
		if(conn==null)
		{
			try {
		
			 Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libaraymanagment", "root", "engineer");
             System.out.println("Suucessfully Connected");
         } 
		catch (Exception ex) {
             ex.printStackTrace();
         }
		}
		return conn;
	}


}
