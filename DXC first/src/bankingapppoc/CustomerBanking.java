package bankingapppoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MyBankClass <T> { 
	T obj;
	
	void create(T obj) { 
		this.obj = obj;
	}
	
	T getInstance() {
		return obj;
	}
}
public class CustomerBanking {

	InputStreamReader isr = null;
	BufferedReader buff = null;
	ICICI mICICI = null;
	HDFC mHDFC = null;
	Axis mAxis = null;
	
	boolean bankOpen = true;
	String bankChoice;
	

	List<Customer> mCustomerList = new ArrayList<Customer>();
	
	public static void main(String[] args) throws Exception {
		
		CustomerBanking mObject = new CustomerBanking();
	    
		mObject.isr = new InputStreamReader(System.in);
		mObject.buff = new BufferedReader(mObject.isr);
		do {
			Customer mCustomer = new Customer();
			System.out.println("Welcome to INDIAN BANKING SYSTEM\n");
			System.out.println("SELECT  YOUR BANK\n1. ICICI\n2. HDFC\n3. AXIS");
			String mBankChoice = mObject.buff.readLine();
			
			String mOperationChoice, continueChoice;
			boolean transaction = true;
			
			switch(Integer.parseInt(mBankChoice))
			{
			case 1: MyBankClass<ICICI> obj = new MyBankClass<ICICI>();
					obj.create(new ICICI());
					mObject.mICICI = obj.getInstance();
					do {
						System.out.println("SELECT  YOUR  Operation\n1. Open Account\n2. Deposit\n3. WithDrawl\n4. Open FD");
						mOperationChoice = mObject.buff.readLine();
						switch(Integer.parseInt(mOperationChoice)) {
						case 1: mObject.mICICI.openAccount(mObject.buff, mCustomer);
								break;
						case 2: mObject.mICICI.deposit(mObject.buff, mCustomer);
								break;
						case 3: mObject.mICICI.withdrawl(mObject.buff, mCustomer);
								break;
						case 4: mObject.mICICI.openFD(mObject.buff, mCustomer);
								break;
						default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = mObject.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							transaction = false;
						int mOperationCounter = mCustomer.getOperationCounter()+1;
						mCustomer.setOperationCounter(mOperationCounter);
					}while(transaction);
					mCustomer.setBankType("ICICI BANK");
					break;
			
			case 2: MyBankClass<HDFC> obj1 = new MyBankClass<HDFC>();
					obj1.create(new HDFC());
					mObject.mHDFC = obj1.getInstance();
					do {
						System.out.println("SELECT  YOUR  Operation\n1. Open Account\n2. Deposit\n3. WithDrawl\n4. Open FD");
						mOperationChoice = mObject.buff.readLine();
						switch(Integer.parseInt(mOperationChoice)) {
						case 1: mObject.mHDFC.openAccount(mObject.buff, mCustomer);
								break;
						case 2: mObject.mHDFC.deposit(mObject.buff, mCustomer);
								break;
						case 3: mObject.mHDFC.withdrawl(mObject.buff, mCustomer);
								break;
						case 4:  mObject.mHDFC.openFD(mObject.buff, mCustomer);
								break;
						default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = mObject.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							transaction = false;
						int mOperationCounter = mCustomer.getOperationCounter()+1;
						mCustomer.setOperationCounter(mOperationCounter);
					}while(transaction);
					mCustomer.setBankType("HDFC BANK");
					break;
			
			case 3: MyBankClass<Axis> obj2 = new MyBankClass<Axis>();
					obj2.create(new Axis());
					mObject.mAxis = obj2.getInstance();
					do {
						System.out.println("SELECT  YOUR  Operation\n1. Open Account\n2. Deposit\n3. WithDrawl\n4. Open FD");
						mOperationChoice = mObject.buff.readLine();
						switch(Integer.parseInt(mOperationChoice)) {
						case 1: mObject.mAxis.openAccount(mObject.buff, mCustomer);
								break;
						case 2: mObject.mAxis.deposit(mObject.buff, mCustomer);
								break;
						case 3: mObject.mAxis.withdrawl(mObject.buff, mCustomer);
								break;
						case 4:  mObject.mAxis.openFD(mObject.buff, mCustomer);
								break;
						default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = mObject.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							transaction = false;
						int mOperationCounter = mCustomer.getOperationCounter()+1;
						mCustomer.setOperationCounter(mOperationCounter);
					}while(transaction);
					mCustomer.setBankType("Axis BANK");
					break;
			
			default: System.out.println("No Choice of Bank Done");
			}
			System.out.println("Do you Want to End Bank Selection\nYes\nNo");
			mObject.bankChoice = mObject.buff.readLine();
			if(mObject.bankChoice.equalsIgnoreCase("Yes"))
				mObject.bankOpen = false;
			mObject.mCustomerList.add(mCustomer);
		}while(mObject.bankOpen);
		System.out.println("Total No of customers are "+mObject.mCustomerList.size());
		System.out.println("=====================  Below are the Customers  ==============================\n\n\n");
		for(Customer customer: mObject.mCustomerList) { 
			System.out.println("Customer Details are:\nCustomer Bank: " + customer.getBankType() + "\nName: "
					+ customer.getName() + "\nEmail: " + customer.getEmail() + "\nPhone: " + customer.getPhone()
					+ "\nBalance: " + customer.getBalance() + "\nNo Of Operations Performed: "
					+ customer.getOperationCounter() + "\n1. OpenAccountCounter: " + customer.getOpenAccountCounter()
					+ "\n2. Deposit Counter: " + customer.getDepositCounter() + "\n3. Withdrawl Counter: "
					+ customer.getWithdrawlCounter() + "\n4. OpenFD Counter: " + customer.getOpenFDCounter()+"\n\n");
		}
		}	
		
}
