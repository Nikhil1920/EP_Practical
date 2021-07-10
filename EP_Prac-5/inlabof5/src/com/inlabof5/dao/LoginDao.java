package com.inlabof5.dao;

import java.sql.*;

public class LoginDao {
	public boolean check(String mail, String password) {

		String dbUserName = "system";

        String dbUserPassword = "nikhil";
        
        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";
        
        String query = "SELECT * FROM farewell WHERE email=? and pass=?";
        
        boolean status = false;
        
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
            Connection con = DriverManager.getConnection(oracleurl, dbUserName,dbUserPassword);
            
			PreparedStatement prepst = con.prepareStatement(query);
			
			prepst.setString(1, mail);
			
			prepst.setString(2, password);
			
			ResultSet rs = prepst.executeQuery();
			
			status = rs.next();
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public String getUserfirstname(String mail) {
		String dbUserName = "system";

        String dbUserPassword = "nikhil";
        
        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";
        
        String query = "SELECT firstname FROM farewell WHERE email=?";
        
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
            Connection con = DriverManager.getConnection(oracleurl, dbUserName,dbUserPassword);
            
			PreparedStatement prepst = con.prepareStatement(query);
			
			prepst.setString(1, mail);
			
			ResultSet rs = prepst.executeQuery();
			
			rs.next();
			
			return rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error";
	}
	
	public boolean submitted(String mail) {
		boolean submitted = false;
		
		String dbUserName = "system";

        String dbUserPassword = "nikhil";
        
        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";
        
        String query = "SELECT submitted FROM farewell WHERE email=?";
        
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
            Connection con = DriverManager.getConnection(oracleurl, dbUserName,dbUserPassword);
            
			PreparedStatement prepst = con.prepareStatement(query);
			
			prepst.setString(1, mail);
			
			ResultSet rs = prepst.executeQuery();
			
			rs.next();
			
			String output = rs.getString(1);
			
			if (output.equals("Y")) {
				submitted = true;
			}
			
			return submitted;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return submitted;
	}
}
