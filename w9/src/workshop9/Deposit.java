/*
 * Name: Yuki Waka
 * Date: August 3,2020
 * 
 * */
package workshop9;

public class Deposit extends Thread {
	private StrangeBankAccount account;
	private int balance;
	private String[] currency;
	
	public Deposit(StrangeBankAccount acc, String[] cur) {
		this.account = acc;
		balance = 1;
		this.currency = cur;
	}
	 
	@Override
	public void run() {
		int i = 0;
		Thread activeThread = Thread.currentThread();

		System.out.println("******The thread named: " + activeThread.getName() + " is starting.******\n");

		
		while (i >= 0 && i < 6) {
			synchronized(account) {
				account.deposit(1, currency[i]);
				
				try {
					if (i < 6 && i >= 0) i++;
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}