package com.dxc.feesmanagement;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Accountant {
	


	public void addStu(BufferedReader buff, Connection mConnectionObject) throws Exception{

			PreparedStatement stmtInsert = mConnectionObject.prepareStatement("insert into Accountant values(?,?,?,?,?,?,?,?,?,?,?)");
			
			System.out.println("Enter your Name");
			String name = buff.readLine();
			System.out.println("Enter your Email");
			String email = buff.readLine();
			System.out.println("Enter your Course");
			String course = buff.readLine();
			System.out.println("Enter your Fee");
			String fee = buff.readLine();
			System.out.println("Enter your Paid");
			String paid = buff.readLine();
			System.out.println("Enter your Due");
			String due = buff.readLine();
			System.out.println("Enter your Address");
			String address = buff.readLine();
			System.out.println("Enter your City");
			String city = buff.readLine();
			System.out.println("Enter your State");
			String state = buff.readLine();
			System.out.println("Enter your Country");
			String country = buff.readLine();
			System.out.println("Enter your Phone");
			String phone = buff.readLine();
			
			stmtInsert.setString(1, name);
			stmtInsert.setString(2, email);
			stmtInsert.setString(3, course);
			stmtInsert.setString(4, fee);
			stmtInsert.setString(5, paid);
			stmtInsert.setString(6, due);
			stmtInsert.setString(7, address);
			stmtInsert.setString(8, city);
			stmtInsert.setString(9, state);
			stmtInsert.setString(10, country);
			stmtInsert.setString(11, phone);
			System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
			
	}


	public void viewStu(BufferedReader buff, Connection mConnectionObject) throws Exception {
		
			Statement stmt = mConnectionObject.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from Accountant");
			while (rs.next())
				System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4)+
						","+rs.getString(5)+ ", " + rs.getString(6)+ ", " + rs.getString(7)+ ", " + rs.getString(8)
						+ ", " + rs.getString(9)+ ", " + rs.getString(10)+ ", " + rs.getString(11));
		
		 
	}

	
}
	