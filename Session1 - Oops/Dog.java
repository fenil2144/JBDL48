import java.io.Serializable;

public class Dog implements Serializable{
	private String name;
	private String breed;
	private int age;
	private String color;
	
	public void eat() {
		System.out.println("I am Eating!");
	}
	
	public void bark() {
		System.out.println("I am Barking");
	}
	
	public void display() {
		System.out.println("Name= "+name+" Breed= "+breed+" age= "+age+" color= "+color);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = "Mr."+name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		dog.name="Jimmy";
		dog.breed="German";
		dog.age=10;
		dog.color="White";
		
		dog.display();
		dog.eat();
	
		
	}
}

