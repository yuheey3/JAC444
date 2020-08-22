/*
 * Name: Yuki Waka
 * Date: August 3,2020
 * 
 * */
package workshop9;

public class Withdraw extends Thread {
	private StrangeBankAccount account;
	
	public Withdraw(StrangeBankAccount acc) {
		this.account = acc;
	}
	
	@Override
	public void run() {
		Thread activeThread = Thread.currentThread();
		
		System.out.println("******The thread named: " + activeThread.getName() + " is starting.******\n");
		
		for (int i = 0; i < 6; i++) {
			synchronized(account) {
				
				account.withdraw(1);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
	}
}