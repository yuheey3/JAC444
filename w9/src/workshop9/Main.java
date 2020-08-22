/*
 * Name: Yuki Waka
 * Date: August 3,2020
 * 
 * */
package workshop9;


public class Main {

	public static void main(String[] args) {
		//set the initial currency
		String[] currency = {"Dollar", "Euro", "Euro", "Pound", "Pound", "Pound"};
		
		//declare account object
		StrangeBankAccount account = new StrangeBankAccount(0, "");
		
		//thread for withdraw and deposit
		Thread withdraw = new Withdraw(account);
		Thread deposit = new Deposit(account,currency);
		
		//start the thread
		withdraw.start();
		deposit.start();
		
	}
	
}