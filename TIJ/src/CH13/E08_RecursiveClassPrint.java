package CH13;

/******************
 * Exercise 8 ****************** Write a method that takes an object and
 * recursively prints all the classes in that object's hierarchy.
 ***********************************************/
public class E08_RecursiveClassPrint {
	static void printClasses(Class<?> c) {
		if (c == null)
			return;
		System.out.println(c.getName());
		for (Class<?> k : c.getInterfaces()) {
			System.out.println("Interface: " + k.getName());
			printClasses(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}

	public static void main(String args[]) throws Exception {
		for (int i = 0; i < args.length; i++) {
			System.out.println("Displaying " + args[i]);
			printClasses(Class.forName(args[i]));
			if (i < args.length - 1)
				System.out.println("==================");
		}
	}
}
