package aleksandrfeldman_sec003_ex01;

public class Account {
	private double balance;
	private String clientName;
	
	public Account(String clientName, double startBalance) {
		this.clientName=clientName;
		this.balance=startBalance;
	}
	
	public synchronized void withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			System.out.println("$" + amount + " withdrawn successfully from "+clientName+" account."+" New balance:"+balance);
		} else {
			System.out.println("Declined. Not enough funds for withdraw from "+clientName+" account");
		}
	}
	public synchronized void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("$" + amount + " deposited successfully to "+clientName+" account."+" New balance:"+balance);
		} else {
			System.out.println("Declined. Insert money");
		}
	}
	
}
