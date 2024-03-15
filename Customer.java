package codSoft_Int;

import java.util.*;

class Account
{
	int bal;
	Account(int b)
	{
		bal=b;
	}
	boolean isSufficientBal(int w)
	{
		if(bal>w)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	void withdraw(int amt,String g1)
	{
		bal=bal-amt;
		System.out.println("Transaction Successfully");
		System.out.println(g1 +" your current balance is " + bal);
	}
}

class ATM implements Runnable
{
	String s2;
	Account x1;
	ATM(Account j1,String h1)	
	{
		x1=j1;
		s2=h1;
	}
	public void run()
	{
		Scanner s1=new Scanner(System.in);
		synchronized(x1)
		{
		System.out.println("Enter Amount for " + s2 +":");
		int amt=s1.nextInt();
		if(x1.isSufficientBal(amt))
		{
			x1.withdraw(amt,s2);
		}
		else
		{
			System.out.println("Insufficient Balance ");
		}
		}
	}
}
public class Customer
{
	public static void main(String[] arg)
	{
		Account a1=new Account(5000);
		ATM c1=new ATM(a1,"Shital");
		ATM c2=new ATM(a1,"Chhoti");
		Thread t1=new Thread(c1);
		Thread t2=new Thread(c2);
		t1.start();
		t2.start();
	}
}
