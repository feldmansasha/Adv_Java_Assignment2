package aleksandrfeldman_sec003_ex01;

public class Transaction implements Runnable{
	private String type;
	private double amount;
	private Account account;
	
	public Transaction(Account account, double amount, String transaction) {
		this.account=account;
		this.amount=amount;
		this.type=transaction;
	}
	
	@Override
	public void run() {
		if(type.equals("deposit")) {
			account.deposit(amount);
		} else if(type.equals("withdraw")) {
			account.withdraw(amount);
		} else {
			System.out.println("Wrong transaction type!");
		}
	}
}
