package com.email;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmailAppDataBaseUtilityClass {
    static  Connection conn=null;
    static final String URL="jdbc:mysql://localhost:3306/ emailapplication";
    static final String UN="Pratibha";
    static final String PASS="route";
    static String DB="com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() {
    	try {
    		//load the driver
    		Class.forName(DB);
    		conn = DriverManager.getConnection(URL, UN, PASS);
    		
    		if(conn!=null) {
    			System.out.println("Connected");
    		}else {
    			System.out.println("Not connected");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
  
    	return conn;
    	
    	 }
    
}
