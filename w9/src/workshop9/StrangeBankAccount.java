/*
 * Name: Yuki Waka
 * Date: August 3,2020
 * 
 * */
package workshop9;


public class StrangeBankAccount {
	
	private int balance;
	private String currency;
	
	StrangeBankAccount(int amount, String cur) {
		this.balance = amount;
		this.currency = cur;
	}
	
	public void setBalance(int amount) {
		this.balance = amount;
	}
	
	public void setCurrency(String cur) {
		this.currency = cur;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	//deposit
	public synchronized void deposit(int amount, String cur) {
		//if balance is not empty and currency is different
		while (getBalance() != 0 && getCurrency() != cur) {
			try {
				System.out.println("You are trying to deposit the different currency.\n");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		} 
		//currency is the same
		if (getCurrency() == cur) {
			setCurrency(cur);
			setBalance(balance += amount);
		//currency is the different	
		} else {
			setCurrency(cur);
			setBalance(amount);
		}
		
		System.out.println("Deposited Cpmpleted!  -->  " + amount + " " + cur + ".");
		System.out.println("Account balance is now: " + getBalance() + " " + getCurrency() + "\n");
		notify();
	}
	//withdraw
	public synchronized void withdraw(int amount) {
		//if amount user entered is bigger than balance
		while (getBalance() < amount) {
			try {
				System.out.println("Insuficient balance! Please check again\n");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		//withdraw
		setBalance(getBalance() - amount);
		
		System.out.println("Withdraw Completed! -->  " + amount + " " + getCurrency());
		System.out.println("Account balance is now: " + getBalance() + " " + getCurrency() + "\n");
		notify();
	}

}