package bank;

public class BankAccount {
	
	String customerName;
	String accountNumber;
	private double balance;
	
	BankAccount(String customerName,String accountNumber,double initialBalance ) throws InvalidAmountException {
		
		if(initialBalance<=0) {
			throw new InvalidAmountException("The Initial Balance Cannot be 0 or Negative");
		}
		this.customerName=customerName;
		this.accountNumber=accountNumber;
		this.balance=initialBalance;
	}
	
	
	public void deposit(double money) throws InvalidAmountException{
		
		if(money<=0) {
			throw new InvalidAmountException("The depositing Amount should be greater than 0");
		}
		
		else {
			balance+=money;
			System.out.println("Deposit Sucessfull..");
			System.out.println();
			System.out.println("Updated Balance :"+balance);
			
			
		}
		
	}
	
	
	public void withdraw(double money) throws InvalidAmountException,InsufficientBalanceException{
		
		if(money<=0) {
			throw new InvalidAmountException("Cannot Withdraw Amount less than 0");
		}
		
		else if(money>balance) {
			throw new InsufficientBalanceException("Insufficient Balance!!!");
			
		}
		else {
			balance-=money;
			System.out.println("Withdrawal  Sucessfull..");
			System.out.println();
			System.out.println("Updated Balance :"+balance);
		}
		
	}
	
	 public void displayBalance() {
	        System.out.println("================================");
	        System.out.println("        ACCOUNT DETAILS");
	        System.out.println("================================");
	        System.out.println("Customer Name  : " + customerName);
	        System.out.println("Account Number : " + accountNumber);
	        System.out.println("Current Balance: ₹" + balance);
	        System.out.println("================================");
	    }
	
	
	
	
	

}
