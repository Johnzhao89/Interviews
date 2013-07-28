package CH4;
class A {}
public class NewVarArgs{
	static void printArray(Object... args){// var list
		for(Object obj: args)
			System.out.println(obj + " ");
		System.out.println();
	}
	static void f(int required, String... trailing){
		System.out.print("required: "+required + " ");
		for(String s: trailing)
			System.out.print(s+" ");
		System.out.println();
	}
	
	static void g(int... args){
		System.out.print(args.getClass());
		System.out.println(" length "+ args.length);
	}
	static void h(Character... args){
		System.out.print(args.getClass());
	    System.out.println(" length " + args.length);
	}
	
	public static void main(String[] args){
		printArray(new Integer(47), new Float(3.14), new Double(11.1));
		printArray(47, 3.14F, 11.11);
		printArray("one", "two", "three");
		printArray(new A(), new A(), new A());
		printArray((Object[]) new Integer[] {1,2,3,4});
		printArray();
		f(1,"one");
		f(2,"two", "three");
		g(1);
		g();
		h('a');
		h();
	}
}