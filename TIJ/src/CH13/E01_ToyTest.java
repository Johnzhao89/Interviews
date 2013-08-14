package CH13;

/**********************
 * Exercise 1 ********************* In ToyTest.java, comment out Toy's default
 * constructor and explain what happens.
 *******************************************************/
interface HasBatteries2 {
}

interface Waterproof2 {
}

interface Shoots2 {
}

class Toy2 {
	// Toy() {}
	Toy2(int i) {
	}
}

class FancyToy2 extends Toy2 implements HasBatteries, Waterproof, Shoots {
	FancyToy2() {
		super(1);
	}
}

public class E01_ToyTest {
	static void printInfo(Class<?> cc) {
		System.out.println("Class name: " + cc.getName() + "is interface? ["
				+ cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("typeinfo.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find FancyToy");
			return;
		}
		printInfo(c);
		for (Class<?> face : c.getInterfaces())
			printInfo(face);
		Class<?> up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Cannot instantiate");
			return;
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");
			return;
		}
		printInfo(obj.getClass());
	}
}
