package com.inlabof5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubmitfeedbackDao {
	public boolean submit(String mail, String feedback) {
		
		boolean status = false;
		
		String dbUserName = "system";

        String dbUserPassword = "nikhil";
        
        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";
        
        String query = "UPDATE farewell SET feedback=? WHERE email=?";
        
        String updatesubmitted = "UPDATE farewell SET submitted='Y' WHERE email =?";
        
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			
            Connection con = DriverManager.getConnection(oracleurl, dbUserName,dbUserPassword);
            
			PreparedStatement prepst = con.prepareStatement(query);
			
			prepst.setString(1, feedback);
			
			prepst.setString(2, mail);
			
			int num = prepst.executeUpdate();
			
			if(num == 1) {
				
				status = true;
				
				PreparedStatement anotherprepst = con.prepareStatement(updatesubmitted);
				
				anotherprepst.setString(1, mail);
				
				anotherprepst.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println(e + "\n Please try again");
		}
		return status;
	}
	public String getfeedback(String mail) {
		String feedback = "Error please try again";
		
		String dbUserName = "system";

        String dbUserPassword = "nikhil";
        
        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";
        
        String query = "SELECT feedback FROM farewell WHERE email =?";
        
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			
            Connection con = DriverManager.getConnection(oracleurl, dbUserName,dbUserPassword);
            
			PreparedStatement prepst = con.prepareStatement(query);
			
			prepst.setString(1, mail);
			
			ResultSet rs = prepst.executeQuery();
			
			rs.next();
			
			feedback = rs.getString(1);
			
		} catch (Exception e) {
			System.out.println(e + "\n Please try again");
		}
        
        return feedback;
	}
}
