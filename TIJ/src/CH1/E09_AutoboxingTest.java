package CH1;
/****************** Exercise 9 ******************
 * Write a program to demonstrate that
 * autoboxing works for all the primitive types
 * and their wrappers.
 ************************************************/

public class E09_AutoboxingTest{
	public static void main(String[] args){
		Byte by=1;
		byte bt=by;
		System.out.println("byte="+bt);
		Short sh=1;
		short s=sh;
		Integer in = 1;
        int i = in;
		System.out.println("int = " + i);
        Long lo = 1L;
        long l = lo;
        System.out.println("long = " + l);
        Boolean bo = true;
        boolean b = bo;
        System.out.println("boolean = " + b);
        Character ch = 'x';
        char c = ch;
        System.out.println("char = " + c);
        Float fl = 1.0f;
        float f = fl;
        System.out.println("float = " + f);
        Double db = 1.0d;
        double d = db;
        System.out.println("double = " + d);
	}
	
}