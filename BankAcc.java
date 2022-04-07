package Day1ab;

public class BankAcc
{
	private int balance=1000;
	public void deposit(int amount)
	{
		this.balance += amount; 
		System.out.println(balance);
	}
	public void withdraw(int amount)
	{
		if(this.balance - amount >999)
		this.balance -= amount;
		else
			System.out.println("Min balance");
			
	}
	public void bank_balance()
	{
		System.out.println(balance);
	}	

}
