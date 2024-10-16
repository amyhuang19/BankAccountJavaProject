import java.util.HashMap; //to use hashmaps
import java.util.Scanner; //to use Scanner for user I/O

public class Main {
	public static void main(String[] args) {
		int accountNumCount = 1000; //base num for accountNums

		//Use HashMap to store multiple bank accounts (where key is account number)
		HashMap<Integer, BankAccount> accounts = new HashMap<>();
			//Integer: key for bank account number
			//BankAccount: to use bank account number class
		
		//Create menu for users to perform actions
		Scanner scanner = new Scanner(System.in);
		
		boolean continueMenu = true;
		while(continueMenu == true) {

			int accountNumber = 0;
			String accountName;
			
			//Create an account (if need) and get the account holder name
			String createAccountQuestion;
			System.out.println("Would you like to create an account (y/n): ");
			createAccountQuestion = scanner.next();
			if (createAccountQuestion.equals("y")) { //create a new account
				System.out.println("Enter new account holder name.");
				accountName = scanner.nextLine();
				//set initial values of account
				accountNumCount++;
				BankAccount newAccount = new BankAccount(accountNumCount, accountName, 0);
				//put new account into HashMap
				accounts.put(newAccount.getAccountNumber(), newAccount);
				System.out.println("New account created. Account number: " + newAccount.getAccountNumber());
				accountNumber = newAccount.getAccountNumber();
			} else if (createAccountQuestion.equals("n")) {
				System.out.println("Accessing exisitng account.");
				System.out.println("Please Enter account number: ");
				int tempAccountNum = scanner.nextInt();
				//check if account number exists
				if (accounts.containsKey(tempAccountNum)) { //account exists
					accountName = accounts.get(tempAccountNum).getAccountHolderName();
					accountNumber = tempAccountNum;
                    System.out.println("Account of " + accountName + " is valid.");
				} else { //account does not exist
                    scanner.close();
					continueMenu = false;
					throw new IllegalArgumentException("Account is NOT valid");
				} //if
			} else {
                scanner.close();
				continueMenu = false;
				throw new IllegalArgumentException("Response must be in (y/n) format.");
			} //if

			//ask to make a deposit
			String makeDepositQuestion;
			System.out.println("Would you like to make a deposit (y/n): ");
			makeDepositQuestion = scanner.next();
			if (makeDepositQuestion.equals("y")) {
				//get amount to deposit
				int depositAmount;
				System.out.println("Enter amount to deposit: ");
				depositAmount = scanner.nextInt();
		
				//deposit the amount
				BankAccount account = accounts.get(accountNumber);
				account.depositing(depositAmount);
			} else if (makeDepositQuestion.equals("n")) {
				System.out.println("No deposit will be made.");
			} else {
                scanner.close();
				continueMenu = false;
				throw new IllegalArgumentException("Response must be in (y/n) format.");
			} //if
			
			//ask to make a withdrawal
			String makeWithdrawalQuestion;
			System.out.println("Would you like to make a withdrawal (y/n): ");			
			makeWithdrawalQuestion = scanner.next();
			if (makeWithdrawalQuestion.equals("y")) {
				//get amount to withdraw
				int withdrawalAmount;
				System.out.println("Enter amount to withdraw: ");
				withdrawalAmount = scanner.nextInt();
				
				//withdraw the amount
				BankAccount account = accounts.get(accountNumber);
				account.withdrawing(withdrawalAmount);
			} else if (makeWithdrawalQuestion.equals("n")) {
				System.out.println("No withdrawal will be made.");
			} else {				
                scanner.close();
				continueMenu = false;
				throw new IllegalArgumentException("Response must be in (y/n) format.");
			} //if

			//ask to continue to use the menu
			String continueBanking;
			System.out.println("Would you like to use the banking system again (y/n): ");
			continueBanking = scanner.next();	
			if (continueBanking.equals("y")) {
				System.out.println("Okay, starting over... ");
			} else if(continueBanking.equals("n")) {
				System.out.println("Okay, exiting... ");
				continueMenu = false;
			} else {
                scanner.close();
				continueMenu = false;
				throw new IllegalArgumentException("Response must be in (y/n) format.");
			} //if
		} //while
		scanner.close();
	} //main

} //Main