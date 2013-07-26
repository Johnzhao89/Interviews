package CH2;

/****************** Exercise 2 *****************
 * Create a class containing a float and use it to
 * demonstrate aliasing.
 ***********************************************/
class Intergral{
	float f;
}

public class E02_Aliasing {
	public static void main (String[] args){
		Intergral n1= new Intergral();
		Intergral n2= new Intergral();
		n1.f = 9f;
		n2.f = 47f;
		System.out.println("1: n1.f: " + n1.f + ", n2.f: " + n2.f);
		n1 = n2;
		System.out.println("1: n1.f: " + n1.f + ", n2.f: " + n2.f);
		n1.f = 27f;
		System.out.println("1: n1.f: " + n1.f + ", n2.f: " + n2.f);
		
	}
}