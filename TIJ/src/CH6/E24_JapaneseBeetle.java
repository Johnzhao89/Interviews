package CH6;
/****************** Exercise 24 ****************
 * In Beetle.java, inherit a specific type of
 * beetle from class Beetle, following the same
 * format as the existing classes. Trace and
 * explain the output.
 ***********************************************/
class JapaneseBeetle extends Beetle{
	int m = printInit("JapaneseBeetle.m initialized");
    JapaneseBeetle() {
      System.out.println("m = " + m);
      System.out.println("j = " + j);
    }
    static int x3 =
      printInit("static JapaneseBeetle.x3 initialized");
}

public class E24_JapaneseBeetle {
    public static void main(String args[]) {
      new JapaneseBeetle();
    }
}



