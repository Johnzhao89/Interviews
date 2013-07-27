package CH4;

/****************** Exercise 5 *****************
 * Create a class called Dog with an overloaded
 * bark() method. Your method should be
 * overloaded based on various primitive data
 * types, and should print different types of barking,
 * howling, etc., depending on which overloaded
 * version is called. Write a main() that calls
￼ * all the different versions.
 ***********************************************/
class Dog{
	public void bark(){
		System.out.println("Deafult bark!");
	}
	public void bark(float i) {
        System.out.println("int bark = howl");
      }
    public void bark(double d) {
        System.out.println("double bark = yip");
      } 
}

class Dog2{
	public void bark(int i, double d) {
        System.out.println("int, double bark");
      }
      public void bark(double d, int i) {
        System.out.println("double, int bark");
      }
}

public class E05_OverloadedDog {
    public static void main(String args[]) {
      Dog dog = new Dog();
      dog.bark();
      dog.bark(1);
      dog.bark(1.1);// auto considered as a double
      
      Dog2 dog2 = new Dog2();
      dog2.bark(1, 2.2);
      dog2.bark(2.2, 1);
    }
  }