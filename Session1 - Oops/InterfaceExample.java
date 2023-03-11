interface Language{
	void getName(String name);
	void getNumberOfCharachters() ;
	
	default void depositDigitalCurrency() {
		System.out.println("Default Implementation");
	}
}

class ProgrammingLanguage extends HelloWorld implements Language{

	@Override
	public void getName(String name) {
		System.out.println("Name = "+name);
		
		System.out.println("Name = "+name);
		System.out.println("Name = "+name);
		
	}

	@Override
	public void getNumberOfCharachters() {
		System.out.println("I am Returning Number of Chars");
	}
	
	@Override
	void depositDigitalCurrency() {
	}
	
	
}

public class InterfaceExample {
	
	public static void main(String[] args) {
//		Language language = new Language();
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.getName("Java");
	}

}
