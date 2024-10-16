public class BankAccount{
	//class variables
	private final int accountNumber;
	private final String accountHolderName;
	private int balance;

	//Constructor
	BankAccount(int accountNumber, String accountHolderName, int balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	} //BankAccount


	//getter methods:
	public int getAccountNumber() {
		return accountNumber;
	} //balance

	public String getAccountHolderName() {
		return accountHolderName;
	} //accountHolderName

	public int getBalance() {
		return balance;
	} //balance

	//other methods
	public void depositing(int newMoney) {
		if(newMoney <= 0) { //money to deposit cannot be 0/negative
			throw new IllegalArgumentException("Deposit amount cannot be 0 or negative.");
		} else {
			this.balance = this.balance + newMoney;
			System.out.println("Deposit sucessful. Current balance: " + balance + ".");
		} //if
	} //depositing

	public void withdrawing(int amount) {
		if (amount > balance) {
			throw new IllegalArgumentException("Withdrawal amount cannot be greater than balance.");
		} else {
			this.balance = this.balance - amount;
			System.out.println("Withdrawal sucessful. Current balance: " + balance + ".");
		} //if
	} //withdrawing

} //BankAccount