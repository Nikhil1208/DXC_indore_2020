package com.dxc.feesmanagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
	InputStreamReader isr = null;
	BufferedReader buff = null;
	Admin mAdmin= null;
	Accountant mAccountant= null;
	
	
	public static void main(String[] args) throws Exception{
		
		FmSystem mObject=new FmSystem();
		
		mObject.isr = new InputStreamReader(System.in);
		mObject.buff = new BufferedReader(mObject.isr);
		
			System.out.println("Welcome to Student fees Management System \n\n\n");
			System.out.println("SELECT  YOUR SYSTEM\n1. Admin\n2. Accountant");
			String mUserChoice = mObject.buff.readLine();
			
			String mOperationChoice, continueChoice;
			boolean choice = true;
            
			switch (Integer.parseInt(mUserChoice)) {
			case 1:
				MyUserClass<Admin> obj = new MyUserClass<Admin>();
				obj.create(new Admin());
				mObject.mAdmin = obj.getInstance();
				do {
					
					System.out.println("SELECT  YOUR  Operation\n1. Add Acc\n2. View Accountant");
					mOperationChoice = mObject.buff.readLine();
					switch (Integer.parseInt(mOperationChoice)) {
					case 1:
						mObject.mAdmin.addAcc(mObject.buff);
						break;
					case 2:
						mObject.mAdmin.viewAcc(mObject.buff);
						break;
					default:
						System.out.println("No Operation Choice Selected");
					}
					System.out.println("Do you Want to Continue\nYes\nNo");
					continueChoice = mObject.buff.readLine();
					if (continueChoice.equalsIgnoreCase("No"))
						choice = false;
				}while(choice);
			     break;
		  case 2:
				MyUserClass<Accountant> obj1 = new MyUserClass<Accountant>();
				obj1.create(new Accountant());
				mObject.mAccountant = obj1.getInstance();
				do {
					System.out.println("SELECT  YOUR  Operation\n1. Add Student\n2. View Student");
					mOperationChoice = mObject.buff.readLine();
					switch (Integer.parseInt(mOperationChoice)) {
					case 1:
						mObject.mAccountant.addStu(mObject.buff);
						break;
					case 2:
						mObject.mAccountant.viewStu(mObject.buff);
						break;
						default:
						    System.out.println("No Operation Choice Selected");
					}
					System.out.println("Do you Want to Continue\nYes\nNo");
					continueChoice = mObject.buff.readLine();
					if (continueChoice.equalsIgnoreCase("No"))
						choice = false;
				}while(choice);
				break;
		  default: System.out.println("No Choice Done");
	   }
		
	}

}
