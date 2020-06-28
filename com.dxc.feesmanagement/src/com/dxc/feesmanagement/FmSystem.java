package com.dxc.feesmanagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

class MyUserClass<T> { 
	T obj;

	void create(T obj) { 
		this.obj = obj;
	}

	T getInstance() { 
		return obj;
	}
}

 
public class FmSystem {
    Connection mConnectionObject;
	public Connection getInstance() throws Exception {
		if(mConnectionObject==null) {
			Class.forName("com.mysql.jdbc.Driver");
			mConnectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb", "Nikhil", "@Nikhil@1208");
			return mConnectionObject;
		}
			else
				return mConnectionObject;
		
	}
	InputStreamReader isr = null;
	BufferedReader buff = null;
	Admin mAdmin= null;
	Accountant mAccountant= null;
	
	
	public static void main(String[] args) throws Exception{
		
		FmSystem mFMSObject=new FmSystem();
		
		mFMSObject.isr = new InputStreamReader(System.in);
		mFMSObject.buff = new BufferedReader(mFMSObject.isr);
		
			System.out.println("Welcome to Student fees Management System \n\n\n");
			System.out.println("SELECT  YOUR SYSTEM\n1. Admin\n2. Accountant");
			String mUserChoice = mFMSObject.buff.readLine();
			
			String mOperationChoice, continueChoice;
			boolean choice = true;
            
			switch (Integer.parseInt(mUserChoice)) {
			case 1:
				MyUserClass<Admin> obj = new MyUserClass<Admin>();
				obj.create(new Admin());
				mFMSObject.mAdmin = obj.getInstance();
				do {
					
					System.out.println("SELECT  YOUR  Operation\n1. Add Acc\n2. View Accountant");
					mOperationChoice = mFMSObject.buff.readLine();
					switch (Integer.parseInt(mOperationChoice)) {
					case 1:
						mFMSObject.mAdmin.addAcc(mFMSObject.buff, mFMSObject.getInstance());
						break;
					case 2:
						mFMSObject.mAdmin.viewAcc(mFMSObject.buff,  mFMSObject.getInstance());
						break;
					default:
						System.out.println("No Operation Choice Selected");
					}
					System.out.println("Do you Want to Continue\nYes\nNo");
					continueChoice = mFMSObject.buff.readLine();
					if (continueChoice.equalsIgnoreCase("No"))
						choice = false;
				}while(choice);
			     break;
		  case 2:
				MyUserClass<Accountant> obj1 = new MyUserClass<Accountant>();
				obj1.create(new Accountant());
				mFMSObject.mAccountant = obj1.getInstance();
				do {
					System.out.println("SELECT  YOUR  Operation\n1. Add Student\n2. View Student");
					mOperationChoice = mFMSObject.buff.readLine();
					switch (Integer.parseInt(mOperationChoice)) {
					case 1:
						mFMSObject.mAccountant.addStu(mFMSObject.buff, mFMSObject.getInstance());
						break;
					case 2:
						mFMSObject.mAccountant.viewStu(mFMSObject.buff, mFMSObject.getInstance());
						break;
						default:
						    System.out.println("No Operation Choice Selected");
					}
					System.out.println("Do you Want to Continue\nYes\nNo");
					continueChoice = mFMSObject.buff.readLine();
					if (continueChoice.equalsIgnoreCase("No"))
						choice = false;
				}while(choice);
				break;
		  default: System.out.println("No Choice Done");
	   }
			
	}
  
}
