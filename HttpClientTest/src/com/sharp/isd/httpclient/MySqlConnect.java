package com.sharp.isd.httpclient;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnect{
	  public static void main(String[] args) {
	    System.out.println("MySQL Connect Example.");
	    Connection conn = null;
	    String url = "jdbc:mysql://ambsys:3306/";
//	    String dbName = "mysharp";
	    String dbName = "tiki";
	    String driver = "com.mysql.jdbc.Driver";
//	    String userName = "mysharp"; 
	    String userName = "tiki"; 
//	    String password = "mysharp";
	    String password = "tiki";
	    try {
//	      Class.forName(driver).newInstance();
	      Class.forName(driver);
	      conn = DriverManager.getConnection(url+dbName,userName,password);
	      System.out.println("Connected to the database");
	      conn.close();
	      System.out.println("Disconnected from database");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	} 
