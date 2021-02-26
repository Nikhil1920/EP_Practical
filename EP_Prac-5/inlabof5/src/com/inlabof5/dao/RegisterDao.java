package com.inlabof5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao {
public boolean register(String fname, String lname, String mail, String password) {
		
		String dbUserName = "system";

        String dbUserPassword = "nikhil";
        
        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";
        
        String query = "INSERT INTO farewell (FIRSTNAME, LASTNAME, EMAIL, PASS) VALUES (?, ?, ?, ?)";
        
        String checkquery = "SELECT * FROM login WHERE email=?";
        
        boolean status = false;
        
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			
            Connection con = DriverManager.getConnection(oracleurl, dbUserName,dbUserPassword);
            
            PreparedStatement checkst = con.prepareStatement(checkquery);
            
            checkst.setString(1, mail);
            
            ResultSet rs = checkst.executeQuery();
            
            if(rs.next())
            	return false;
            
            rs.close();
            
			PreparedStatement prepst = con.prepareStatement(query);
			
			prepst.setString(1, fname);
			
			prepst.setString(2, lname);
			
			prepst.setString(3, mail);
			
			prepst.setString(4, password);
			
			int result = prepst.executeUpdate();
			
			if(result == 1) {
				return true;
			} 
			
			return false;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return status;
	}
}
