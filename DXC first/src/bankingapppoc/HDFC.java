package bankingapppoc;

import java.io.BufferedReader;

public class HDFC implements RBI{

public int ROI = 5;
public int MIN_FD_AMOUNT = 6000;
public int MIN_YEARS = 4;
public int MIN_BAL = 5000;
public int BAL = MIN_BAL;

@Override
public void openAccount(BufferedReader buff, Customer customer) {
	try {
		System.out.println("Enter your Name");
		String name = buff.readLine();
		System.out.println("Enter your Email");
		String email = buff.readLine();
		System.out.println("Enter your Phone");
		String phone = buff.readLine();
		
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhone(phone);
		
		int mOpenAccountCounter = customer.getOpenAccountCounter()+1;
		customer.setOpenAccountCounter(mOpenAccountCounter);
		
		System.out.println("Congratulations your Account is Opened !!");
		System.out.println("your Details are \nName: "+name+"\nEmail: "+email+"\nPhone: "+phone);
	}
	catch(Exception e) {
		System.out.println("Exception is "+e);
	}
}

@Override
public void deposit(BufferedReader buff, Customer customer) {
	try {
		System.out.println("Enter the amount to be deposited");
		String amount = buff.readLine();
		BAL = BAL + Integer.parseInt(amount);
		customer.setBalance(String.valueOf(BAL));
		int mDepositCounter = customer.getDepositCounter()+1;
		customer.setDepositCounter(mDepositCounter);
		System.out.println("Balance is "+BAL);
	}
	catch(Exception e) {
		System.out.println("Exception is "+e);
	}
}

@Override
public void withdrawl(BufferedReader buff, Customer customer) {
	try {
		System.out.println("Enter the amount to be Withdrawl");
		String amount = buff.readLine();
		if(BAL - Integer.parseInt(amount) > MIN_BAL)
			BAL = BAL - Integer.parseInt(amount);
		else
			System.out.println("MIN BAL is not maintained after withdrawl !!");
		customer.setBalance(String.valueOf(BAL));
		int mWithdrawlCounter = customer.getWithdrawlCounter()+1;
		customer.setWithdrawlCounter(mWithdrawlCounter);
		System.out.println("Balance is "+BAL);
	}
	catch(Exception e) {
		System.out.println("Exception is "+e);
	}
}

@Override
public void openFD(BufferedReader buff, Customer customer ) {
	try {
		System.out.println("Enter your FD amount");
		String fdamount = buff.readLine();
		System.out.println("Enter Term Duration of FD");
		String years = buff.readLine();
		if(Integer.parseInt(fdamount) > MIN_FD_AMOUNT && Integer.parseInt(years) > MIN_YEARS) {
			int TotalFDAmount = Integer.parseInt(fdamount) + (ROI*Integer.parseInt(fdamount));
			for(int i=2; i<Integer.parseInt(years); i++)
				TotalFDAmount = TotalFDAmount + (ROI*TotalFDAmount);
			int mOpenCounter = customer.getOpenFDCounter()+1;
			customer.setOpenFDCounter(mOpenCounter);
			System.out.println("Your Total FD Amount after "+years+" years will be "+TotalFDAmount);
		}
			
	}
	catch(Exception e) {
		System.out.println("Exception is "+e);
	}
}

}
