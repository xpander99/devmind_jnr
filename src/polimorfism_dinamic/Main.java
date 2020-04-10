package polimorfism_dinamic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		Animal dog = new Dog();
		Animal cat = new Cat();
		animal.display(); // will call the display m from Animal class
		dog.display(); // will call the display m from Dog class
		cat.display(); // will call the display m from Cat class
	}

}
