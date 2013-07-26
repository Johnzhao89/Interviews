package CH2;

/****************** Exercise 5 *****************
 * Create a class called Dog with two Strings:
 * name and says. In main(), create two dogs,
 * "spot" who says, "Ruff!", and "scruffy" who
 * says, "Wurf!". Then display their names and
 * what they say.
 ***********************************************/

class Dog0{
	String name;
	String says;
}

public class E05_Dogs{
	public static void main(String[] args){
		Dog0 dog1 = new Dog0();
		Dog0 dog2 = new Dog0();
		dog1.name = "spot";
		dog2.name = "scruffy";
		dog1.says = "Ruff!";
		dog2.says = "Wurf!";
		
		System.out.println(dog1.name + " says " + dog1.says);
        System.out.println(dog2.name + " says " + dog2.says);
	}
}