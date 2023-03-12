class Parent{
	protected void method1() {
		System.out.println("From Parent Class");
	}
	
	public static void displayHello() {
		System.out.println("Hello!");
	}
	
	int a = 10;
	
	//Nested Class
	static class NestedClass{
		
	}
}
class Child extends Parent{
	public void method1() {
		super.method1();
		System.out.println("From Child Class");
	}
	
	int a = 20;
}

public class MethodOverriding {
	
	static {
		System.out.println("I am inside Static Block");
	}
	
	public static void main(String[] args) {
		Parent parentObj = new Parent();
		parentObj.method1();
		System.out.println(parentObj.a);
		
		Child childObj = new Child();
		childObj.method1();
		System.out.println(childObj.a);
		
		Parent parentObj2 = new Child();
		parentObj2.method1();
		System.out.println(parentObj2.a);
		
//		Child childObj = new Parent();
//		childObj.method1();
//		System.out.println(childObj.a);
		
		Parent.displayHello();
		
	}

}
