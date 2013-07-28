package CH4;
/****************** Exercise 13 *****************
 * Comment the line marked (1) in
 * ExplicitStatic.java and verify that the static
 * initialization clause is not called. Now
 * uncomment one of the lines marked (2) and
 * verify that the static initialization clause
 * is called. Finally, uncomment the other line marked
 * (2) and verify that static initialization
 * occurs only once.
 ************************************************/
class Cup {
    Cup(int marker) {
      System.out.println("Cup(" + marker + ")");
    }
    void f(int marker) {
      System.out.println("f(" + marker + ")");
    }
}
  class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
      cup1 = new Cup(1);
      cup2 = new Cup(2);
    }
Cups() {
      System.out.println("Cups()");
    }
}
  
  public class E13_LeftToReader {
      public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);  // (1)
      }
       static Cups cups1 = new Cups();  // (2)
       static Cups cups2 = new Cups();  // (2)
    }