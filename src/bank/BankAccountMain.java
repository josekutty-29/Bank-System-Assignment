package bank;
import java.util.*;


public class BankAccountMain {
	
	static Scanner sc=new Scanner(System.in);
    static BankAccount bank=null;
    static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("          BANKING APPLICATION");
        System.out.println("========================================");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Balance Enquiry");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    public static void main(String[] args) {
    	int choice=0;
    	do {
    	printMenu();
    	try {
    	choice=Integer.parseInt(sc.nextLine());
    	switch(choice) {
    	case 1:
    	{
    		System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Account Number: ");
            String accNum = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double initalBalance = Double.parseDouble(sc.nextLine());
            try {
                bank=new BankAccount(name,accNum,initalBalance);
            	System.out.println("Account Created SucessFully...");
            }
            catch(InvalidAmountException e) {
            	System.out.println(e.getMessage());
    		
    	}
            break;
    	}
    	
    	case 2:
    	{
    		
    		if(bank==null) {
    			System.out.print("Please Create a Bank Account First");
    			break;
    		}
    		System.out.println("Enter Deposit Amount : ");
    		double amount=Double.parseDouble(sc.nextLine());
    		try {
    			bank.deposit(amount);
    			
    		}
    		
    		catch(InvalidAmountException e) {
            	System.out.println(e.getMessage());	
    	}
    		break;
    		
    	}
    	
    	
    	case 3:
    	{
    		
    		if(bank==null) {
    			System.out.print("Please Create a Bank Account First");
    			break;
    		}
    		
    		System.out.println("Enter Withdrawal Amount : ");
    		double amount=Double.parseDouble(sc.nextLine());
    		
    		try {
    			bank.withdraw(amount);
    	   		}
    		catch(InvalidAmountException e) {
            	System.out.println(e.getMessage());	
    	     }
    		catch(InsufficientBalanceException e1) {
            	System.out.println(e1.getMessage());	
    	     }
    		
    		break;
    		
    	}
    	
    	
    	
    	case 4:
    	{

    		if(bank==null) {
    			System.out.print("Please Create a Bank Account First");
    			break;
    		}
    		
    		bank.displayBalance();
    		break;
    		
    	}
    	
    	
    	case 5:
    	{
    		
    	   System.out.println("Thankyou for Using Bank Application......");
    		break;
    	
    	}
    	
    	default:
    		System.out.println("please enter a Valid input");
    	
    	}
    	
    	}
    	
    	catch(NumberFormatException e){
    		System.out.println("Please enter a valid number");
    		
    	}
    	
    	}while(choice!=5);
    }
}

