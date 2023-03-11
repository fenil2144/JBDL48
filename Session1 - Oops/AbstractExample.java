abstract class Bank {
	abstract int getRateOfInterest();
	abstract void withdraw(int amount);
	abstract void deposit(String acctNumber, int amount);
	
	public void openAccount() {
		System.out.println("I am Opening Account");
	}
}

class SBI extends Bank{

	@Override
	int getRateOfInterest() {
		return 7;
	}

	@Override
	void withdraw(int amount) {
		System.out.println("I am performing Withdraw in SBI Bank");
	}

	@Override
	void deposit(String acctNumber, int amount) {
		System.out.println("I am Performing Deposit in SBI Bank");
	}
	
}

class HDFC extends Bank{
	@Override
	int getRateOfInterest() {
		return 6;
	}

	@Override
	void withdraw(int amount) {
		System.out.println("I am performing Withdraw in HDFC Bank");
	}

	@Override
	void deposit(String acctNumber, int amount) {
		System.out.println("I am Performing Deposit in HDFC Bank");
	}
}

public class AbstractExample {

}
