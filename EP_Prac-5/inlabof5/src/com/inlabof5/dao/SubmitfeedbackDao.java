package com.inlabof5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SubmitfeedbackDao {
	public boolean submit(String mail, String feedback) {
		
		boolean status = false;
		
		String dbUserName = "system";

        String dbUserPassword = "nikhil";
        
        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";
        
        String query = "UPDATE farewell SET feedback=? WHERE email=?";
        
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			
            Connection con = DriverManager.getConnection(oracleurl, dbUserName,dbUserPassword);
            
			PreparedStatement prepst = con.prepareStatement(query);
			
			prepst.setString(1, feedback);
			
			prepst.setString(2, mail);
			
			int num = prepst.executeUpdate();
			
			if(num == 1) {
				status = true;
			}
			
		} catch (Exception e) {
			System.out.println(e + "\n Please try again");
		}
		return status;
	}
}
