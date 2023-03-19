 
interface FunctionalInterface {
	
	public int getSum(int a,int b);
	
	default void printString() {
		System.out.println("I am default Method");
	}

}

public class FunctionalInterfaceExample{
	
	public static void main(String[] args) {
		
//		FunctionalInterface interfAnnonymous = new FunctionalInterface()
//		{
//
//			@Override
//			public int getSum(int a, int b) {
//				return (a+b);
//			}
//			
//		};
		
//		System.out.println(interfAnnonymous.getSum(10, 20));
//		interfAnnonymous.printString();
		
		//(Arguments List) -> { Body}
		FunctionalInterface interfLambda = (a,b) -> {return (a+b);};
		System.out.println(interfLambda.getSum(10, 20));

		
	}
	
}
