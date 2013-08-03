package CH7;
/****************** Exercise 11 *****************
 * Add class Pickle to Sandwich.java.
 ***********************************************/

class Pickle {
    Pickle() { System.out.print("Pickle()"); }
}
  class Sandwich2 extends PortableLunch {
    Bread b = new Bread();
    Cheese c = new Cheese();
    Lettuce l = new Lettuce();
    Pickle p = new Pickle();
    Sandwich2() { System.out.print("Sandwich()"); }
  }
  public class E11_Pickle {
    public static void main(String args[]) {
      new Sandwich2();
    }
  }



