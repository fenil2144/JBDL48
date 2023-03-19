
class SingletonDesign {
	
	private static SingletonDesign instance;
	
	private SingletonDesign() {
		
	}
	public static SingletonDesign getInstance() {
		
		if(instance == null) {
			synchronized(SingletonDesign.class) {
				if(instance == null) {
					instance = new SingletonDesign();
				}
			}
		}
		return instance;
	}
	
}

 public class SingletonDesignPattern{
	public static void main(String[] args) {
//		SingletonDesignPattern obj = new SingletonDesignPattern();
		
		System.out.println(SingletonDesign.getInstance());
		System.out.println(SingletonDesign.getInstance());

	}
}
