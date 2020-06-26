package com.dxc.feesmanagement;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {
	

	public void addAcc(BufferedReader buff)   {
	try {
		    Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb", "Nikhil", "@Nikhil@1208");
			PreparedStatement stmtInsert = con.prepareStatement("insert into Admin values(?,?,?,?)");
			System.out.println("Enter your Name");
			String name = buff.readLine();
			System.out.println("Enter your Password");
			String password = buff.readLine();
			System.out.println("Enter your Email");
			String email = buff.readLine();
			System.out.println("Enter your Phone");
			String phone = buff.readLine();
			
			stmtInsert.setString(1,name);
			stmtInsert.setString(2,password);
			stmtInsert.setString(3,email);
			stmtInsert.setString(4,phone);

			System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
		
	}
	catch (Exception e) {
		System.out.println(e);
	}
	}

	
	public void viewAcc(BufferedReader buff) {
	
try {
	 Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb", "Nikhil", "@Nikhil@1208");
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from Admin");
	while (rs.next())
		System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
		} 
        catch (Exception e) {
			System.out.println(e);
		}

		
	}
	
}