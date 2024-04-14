package aleksandrfeldman_sec003_ex01;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account1=new Account("Alex", 200);
		Account account2=new Account("Richard", 1000);
		Account account3=new Account("Kevin", 750);
		
		Transaction t1=new Transaction(account1, 100, "deposit");
		Transaction t2=new Transaction(account2, 1200, "withdraw");
		Transaction t3=new Transaction(account1, 250, "withdraw");
		Transaction t4=new Transaction(account3, 100, "deposit");
		
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
		transactions.add(t1);
		transactions.add(t2);
		transactions.add(t3);
		transactions.add(t4);
		
		ExecutorService myExecutor=Executors.newFixedThreadPool(transactions.size());
		for(Transaction t : transactions) {
			myExecutor.execute(t);
		}
		myExecutor.shutdown();
		while(!myExecutor.isTerminated()) {
			
		}
	}

}
