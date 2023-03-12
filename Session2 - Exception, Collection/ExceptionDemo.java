class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String s) {
		super(s);
	}
}
public class ExceptionDemo {
	
	public static void main(String[] args){
		System.out.println(computeDivision(10));
		throw new UserNotFoundException("Custom Exception Thrown By User");
		
	}
	
	public static int computeDivision(int number) throws ArithmeticException{
		
		try {
			int x = 100/number;
			System.out.println("X = "+x);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
			return 20;
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Finally");
		}
		
		System.out.println("Rest of the code");
		return number;
	}
}
