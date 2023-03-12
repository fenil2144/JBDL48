class Animal{
	String name;
	int age;
	
	public void eat() {
		System.out.println("I am Eating");
	}
	
	public void run() {
		System.out.println("I am Running");
	}
}

class DogAnimal extends Animal{
	
	public void bark() {
		System.out.println("I am Barking!");
	}
	
}
class CatAnimal extends Animal{
	public void Meow() {
		System.out.println("I am Meowing!");
	}
	
}

public class InheritanceExample {
	public static void main(String[] args) {
		
		DogAnimal dog = new DogAnimal();
		dog.eat();
		dog.run();
		
		CatAnimal cat = new CatAnimal();
		cat.eat();
		cat.run();
	}
}
