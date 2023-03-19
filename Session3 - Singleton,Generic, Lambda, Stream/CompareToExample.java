import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Developer{
	
	String name;
	BigDecimal salary;
	int age;
	
	public Developer(String name, BigDecimal salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

//	@Override
//	public String toString() {
//		return "Developer [name = "+name+", Salary = "+salary+", age= "+age+"]";
//	}

}


public class CompareToExample {
	
	public static void main(String[] args) {
		
		List<Developer> listOfDeveloper = new ArrayList<Developer>();
		
		listOfDeveloper.add(new Developer("Ketan",  new BigDecimal("100000"), 25));
		listOfDeveloper.add(new Developer("Alvin",  new BigDecimal("500000"), 35));
		listOfDeveloper.add(new Developer("Irin",  new BigDecimal("250000"), 45));
		listOfDeveloper.add(new Developer("Abhay",  new BigDecimal("700000"), 20));
		listOfDeveloper.add(new Developer("Sanya",  new BigDecimal("1100000"), 40));
		
		listOfDeveloper.sort((o1,o2) -> o1.name.compareTo(o2.name));
		
		listOfDeveloper.forEach((developer) -> System.out.println(developer));
		
		System.out.println(listOfDeveloper);
			
		}

	}
