
public class Employee {
	
	private String name;
	int age;
	protected static int count;
	
	public Employee() {
		this("Jack",40);
		count++;
		System.out.println("In Constructor");
	}
	
	public Employee(String name,int age) {
		super();
		count++;
		this.name = name;
		this.age = age;
		System.out.println("In Parameterized Constructor");
	}
	
	public static void main(String[] args) {
		
		int age =25;
		
		Employee obj = new Employee();
//		obj.count = obj.count+1;
		obj.display();
		
		Employee obj2 = new Employee();
//		obj2.count = obj2.count+1;
		obj2.display();
		
		System.out.println(Employee.count);
		
		Employee obj3 = new Employee("Jinesh",25);
		obj3.display();
		
	}
	
	public void display() {
		System.out.println(name+" "+age+" "+count);
	}

//	Constructor
}


