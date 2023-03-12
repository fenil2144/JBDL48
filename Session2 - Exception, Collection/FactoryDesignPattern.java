import java.util.Scanner;

interface Bank{
	void withdraw(int amount);
	void deposit(int amount);
}

class SBI implements Bank{

	@Override
	public void withdraw(int amount) {
		System.out.println("Withdrawl at SBI Bank");
	}

	@Override
	public void deposit(int amount) {
		System.out.println("Deposit at SBI Bank");
	}
}

class HDFC implements Bank{

	@Override
	public void withdraw(int amount) {
		System.out.println("Withdrawl at HDFC Bank");
	}

	@Override
	public void deposit(int amount) {
		System.out.println("Deposit at HDFC Bank");
	}
}

class ATMFactory{
	public Bank getBank(String bankName) {
		if(bankName.equalsIgnoreCase("SBI")) {
			return new SBI();
		}else if(bankName.equalsIgnoreCase("HDFC")) {
			return new HDFC();
		}else {
			return null;
		}
	}
}

public class FactoryDesignPattern {
	
	public static void main(String[] args) {
		ATMFactory atmFactory = new ATMFactory();
		
//		Scanner sc =new Scanner(System.in);
		Bank bank1 = atmFactory.getBank("SBI");
		bank1.deposit(100);;
	}

}
